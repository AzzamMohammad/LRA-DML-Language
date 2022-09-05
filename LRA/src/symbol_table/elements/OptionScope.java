package symbol_table.elements;

import symbol_table.Scope;

public class OptionScope extends Scope {

    String title;
    String value;

    public OptionScope(){
        this.ChildesScope = null;
        this.setScopeName("OptionScope");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(String value) {
        Scope Father = this.FatherScope;
        for (int i = 0 ; i < Father.ChildesScope.size() ; i++){
            OptionScope optionScope = (OptionScope) Father.ChildesScope.get(i).getScope();
            if(optionScope.getValue().equals(value)){
                Scope FatherToGetScopeName = this.getFatherScope();
                while (!FatherToGetScopeName.getFatherScope().getScopeName().equals("HTMLScope"))
                    FatherToGetScopeName = FatherToGetScopeName.getFatherScope();
                ErrorNumber++;
                System.out.println("Error "+ErrorNumber+" in page " +FatherToGetScopeName.getScopeName()+ " in row " + this.getRow() +" : value of options most be different ");
            }
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
