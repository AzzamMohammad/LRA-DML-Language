package symbol_table;

public class HTMLScope extends Scope{
    public HTMLScope(){
        this.ScopeName = "HTMLScope";
    }

    @Override
    public void AddChild(Scope scope) {
        if(ChildNameIsExist(scope)){
            ErrorNumber++;
            System.out.println("Error "+ErrorNumber+" in Page "+scope.getScopeName()+" in row "+scope.getRow()+" : page name already exists");
        }
        super.AddChild(scope);
    }
}
