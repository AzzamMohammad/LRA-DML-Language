package symbol_table.elements;

import symbol_table.Scope;

public class FieldScope extends Scope {
    private String text;
    private String type;
    private String hint;
    private boolean required;

    public FieldScope(){
        this.ChildesScope = null;
        this.setScopeName("FieldScope");
    }


    public String getTextScope() {
        return text;
    }

    public String getTypeScope() {
        return type;
    }

    public String getHintScope() {
        return hint;
    }

    public boolean isRequiredScope() {
        return required;
    }


    public void setTextScope(String text) {
        this.text = text;
    }

    public void setTypeScope(String type) {
        this.type = type;
    }

    public void setHintScope(String hint) {
        this.hint = hint;
    }

    public void setRequiredScope(boolean required) {
        this.required = required;
    }
}
