package ast.visitor.nodes.html.in;

import Visitor.ASTVisitor;
import ast.visitor.Node;

public class Option extends Node {
    public String class_name = "Option";
    private String title;
    private String value;

    public Option(String title, String value){
        this.title = title;
        this.value = value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
    }
}
