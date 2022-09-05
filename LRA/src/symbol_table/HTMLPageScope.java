package symbol_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HTMLPageScope extends Scope{
   public Map<String,Scope> ExtendedPages ;
   public String ControllerName;
   public Scope ControllerPointer;
   public String PageName;

    public HTMLPageScope(){
        ExtendedPages = new HashMap<>();
        this.setScopeName("HTMLPageScope");
        ControllerPointer = null;
    }

    public void setPageName(String pageName) {
        PageName = pageName;
        this.setScopeName(PageName);
    }



    public String getPageName() {
        return PageName;
    }

    public int getExtendedRow() {
        return ExtendedRow;
    }

    public void setExtendedRow(int extendedRow) {
        ExtendedRow = extendedRow;
    }

    public int ExtendedRow;



    public void setControllerName(String controllerName) {
        ControllerName = controllerName;
    }

    public String getControllerName() {
        return ControllerName;
    }


    public void setExtendedPages(ArrayList<String> extendedPagesName){

        Scope scope = this.getFatherScope();
        while (!scope.getFatherScope().getScopeName().equals("root")){
            scope=scope.getFatherScope();
        }
        for (String s:extendedPagesName) {
            if(s.equals(this.PageName)){
                ErrorNumber++;
                System.out.println("Error "+ErrorNumber+" in page " +this.getPageName()+ " in row " + this.getRow() +" : page can not extend from itself ");
            }
           else {
                Scope Sc = scope.getChild(s);
                if(Sc != null){
                    this.ExtendedPages.put(s,Sc);
                }
                else{
                    ErrorNumber++;
                    System.out.println("Error "+ErrorNumber+" in page " +this.getPageName()+ " in row " + this.getRow() +" : page "+ s + " that extended is not found .");
                }
            }
        }
    }



//    public void setExtendedPagesName(ArrayList<String> extendedPagesName) {
//        ExtendedPagesName = extendedPagesName;
//        setExtendedPagePointer(extendedPagesName);
//    }
//
//    public void setExtendedPagePointer(ArrayList<String> extendedPage) {
//        for (String PageName:extendedPage) {
//            Scope PagePointer = this.getFatherScope().getChild(PageName);
//            this.ExtendedPagesPointers.add(PagePointer);
//        }
//    }
//
//    public Scope getContentOfExtendedPage(String PageName){
//        for (Scope S: this.ExtendedPagesPointers) {
//            if(S.ScopeName.equals(PageName))
//                return S;
//        }
//        return null;
//    }
//
//    public ArrayList<Scope> getAllExtendedPage(){
//       return ExtendedPagesPointers;
//    }

    public void SetControllerPointer(String ControllerName){
       Scope scope = this.getFatherScope();
       while (scope.getFatherScope() != null){
           scope=scope.getFatherScope();
       }
       scope = scope.getChild("PHPScope");
       if(scope.getChild(ControllerName) != null){
           this.ControllerPointer = scope.getChild(ControllerName);
       }else {
           ErrorNumber++;
           System.out.println("Error "+ErrorNumber+" in page " + this.getPageName() + "in row " + this.getRow() + " : Controller " + ControllerName + " not found.\n");
       }
    }

    public Scope getControllerPointer() {
        return ControllerPointer;
    }
}
