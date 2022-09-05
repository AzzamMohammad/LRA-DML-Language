package symbol_table.elements;

import symbol_table.Scope;

public class ImageScope extends Scope {
    private String path;
    private String alt_text;

    public ImageScope(){
        this.setScopeName("ImageScope");
    }

    public String getAlt_text() {
        return alt_text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setAlt_text(String alt_text) {
        this.alt_text = alt_text;
    }
}
