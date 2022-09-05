package ast.visitor.nodes.html.out;

import Visitor.ASTVisitor;
import ast.visitor.Node;

public class Img extends Node {
    public String class_name = "Img";
    private String path;
    private String alt_text;

    public void setAlt_text(String alt_text) {
        this.alt_text = alt_text;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlt_text() {
        return alt_text;
    }

    public String getPath() {
        return path;
    }
    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
    }

}
