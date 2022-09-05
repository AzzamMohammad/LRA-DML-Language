package symbol_table;

public class PHPScope extends Scope{
    public PHPScope(){
        this.ScopeName = "PHPScope";
    }

    @Override
    public void AddChild(Scope scope) {
        if(ChildNameIsExist(scope)){
            ErrorNumber++;
            System.out.println("Error "+ErrorNumber+" in controller "+scope.getScopeName()+" in row "+scope.getRow()+" : controller name already exists");
        }
        super.AddChild(scope);
    }
}
