package ast.visitor.nodes.html.in;

import Visitor.ASTVisitor;
import ast.visitor.Node;

public class Field extends Node {
    public String class_name = "Field";
    private String text;
    private String type;//
    private String name;//
    private String hint;//
    private boolean required;//

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getHint() {
        return hint;
    }
    public boolean getRequired(){
        return required;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
    }
}
