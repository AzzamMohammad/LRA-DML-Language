package symbol_table;
import java.util.ArrayList;

public abstract class Scope {
    public Scope FatherScope ;
    public int Row;
    public int Column;
    public static int ErrorNumber;
    public ArrayList<Child> ChildesScope;
    public String ScopeName;
    public Scope(String Name , Scope FatherScope , ArrayList<Child> ChildesScope){
        this.FatherScope = FatherScope;
        this.ChildesScope = ChildesScope;
        this.ScopeName = Name;
    }
    public Scope(){
        this.ChildesScope = new ArrayList<>() ;
        this.FatherScope = null;
        this.ScopeName = "";
        this.Row = 0;
        this.Column = 0;


    }

    public void setRow(int row) {
        Row = row;
    }

    public void setColumn(int column) {
        Column = column;
    }

    public int getRow() {
        return Row;
    }

    public int getColumn() {
        return Column;
    }

    public Scope getFatherScope() {
        return FatherScope;
    }

    public ArrayList<Child> getChildesScope() {
        return ChildesScope;
    }

    public String getScopeName() {
        return ScopeName;
    }

    public void setFatherScope(Scope fatherScope) {
        FatherScope = fatherScope;
    }

    public void setChildesScope(ArrayList<Child> childesScope) {
        ChildesScope = childesScope;
    }

    public void setScopeName(String scopeName) {
        ScopeName = scopeName;
//        System.out.println(ScopeName);
    }

    public boolean ChildNameIsExist(Scope scope){
        boolean help = false;
        for (Child C:ChildesScope) {
            if(C.getName().equals(scope.getScopeName())){
                help = true;
                break;
            }
        }
        return help;
    }

    public void AddChild(Scope scope){
        Child child = new Child(scope.getScopeName(),scope);
        ChildesScope.add(child);
    }
    public Scope getChild (String scopeName){
        for (Child C:ChildesScope) {
            if(C.getName().equals(scopeName)){
                return C.getScope();
            }
        }
        return null;
    }

    public boolean RemoveChild(String scopeName){
        for(int i = 0 ; i < ChildesScope.size() ; i++){
            if(ChildesScope.get(i).getName().equals(scopeName)){
                ChildesScope.remove(i);
                return true;
            }
        }
        return false;
    }



    public void PrintSymbolTable(Scope scope){
        if(scope.ChildesScope == null)
            return;
        for (int i = 0 ; i < scope.ChildesScope.size() ; i++) {
            Child c = scope.ChildesScope.get(i);
            System.out.println(c.name);
            PrintSymbolTable(c.scope);
        }
    }

    public Scope GetControllerOfPage(String PageName){
        Scope scope = this.getChild("HTMLScope");
        scope = scope.getChild(PageName);
        if(scope == null){
            return null;
        }
        else {
            HTMLPageScope htmlPageScope = (HTMLPageScope) scope;
           // System.out.println(htmlPageScope.getControllerPointer().getScopeName());
            return htmlPageScope.getControllerPointer();
        }
    }

}
