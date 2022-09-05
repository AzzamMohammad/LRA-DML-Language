package symbol_table.elements;

import symbol_table.Scope;

import java.util.ArrayList;

public class BigTextScope extends Scope {
    public String scale;
    public ArrayList<TextMustache> value;

    public BigTextScope(){
        this.setScopeName("BigTextScope");
        value = new ArrayList<>();
    }

    public String getScale() {
        return scale;
    }

    public ArrayList<TextMustache> getValue() {
        return value;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public void setValue(ArrayList<TextMustache> value) {
        this.value = value;
    }
}
