package symbol_table;

public class ScopeRoot extends Scope{
    public ScopeRoot(){
        this.setScopeName("root");
        this.setFatherScope(null);
    }

    public void AddRootChild(HTMLScope htmlScope , PHPScope phpScope){
        this.AddChild(htmlScope);
        this.AddChild(phpScope);
         ErrorNumber=0;

    }


}
