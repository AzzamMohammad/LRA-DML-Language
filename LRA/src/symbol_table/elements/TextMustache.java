package symbol_table.elements;

public class TextMustache {
    private String text;
    private String mustache;

    public TextMustache() {
        text = "";
        mustache = "";
    }

    public String getText() {
        return text;
    }

    public String getMustache() {
        return mustache;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMustache(String mustache) {
        this.mustache = mustache;
    }
}
