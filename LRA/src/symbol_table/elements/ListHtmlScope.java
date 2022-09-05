package symbol_table.elements;

import symbol_table.Scope;

import java.util.ArrayList;

public class ListHtmlScope extends Scope {

    private ArrayList<ArrayList<TextMustache>> option;
    boolean numbered ;

    public ListHtmlScope(){
        this.setScopeName("ListHtmlScope");
    }

    public ArrayList<ArrayList<TextMustache>> getOption() {
        return option;
    }

    public boolean isNumbered() {
        return numbered;
    }

    public void setOption(ArrayList<ArrayList<TextMustache>> option) {
        this.option = option;
    }

    public void setNumbered(boolean numbered) {
        this.numbered = numbered;
    }
}
