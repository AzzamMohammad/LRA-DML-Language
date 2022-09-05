package symbol_table.elements;

import symbol_table.Scope;

public class SimpleLinkScope extends Scope {
    private String href;
    private String text;

    public SimpleLinkScope(){
        this.setScopeName("SimpleLinkScope");
    }

    public String getHref() {
        return href;
    }

    public String getText() {
        return text;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setText(String text) {
        this.text = text;
    }
}
