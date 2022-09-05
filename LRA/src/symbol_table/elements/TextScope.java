package symbol_table.elements;

import symbol_table.Scope;

import java.util.ArrayList;

public class TextScope extends Scope {

    private String type;
    private ArrayList<TextMustache> value = new ArrayList<>();

    public TextScope(){
        this.setScopeName("TextScope");
    }

    public String getType() {
        return type;
    }

    public ArrayList<TextMustache> getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(ArrayList<TextMustache> value) {
        this.value = value;
    }
}
