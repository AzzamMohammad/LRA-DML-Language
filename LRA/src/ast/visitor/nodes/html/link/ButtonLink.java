package ast.visitor.nodes.html.link;

import Visitor.ASTVisitor;
import ast.visitor.Node;

public class ButtonLink extends Node {
    public String class_name = "ButtonLink";
    private String href;
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public String getHref() {
        return href;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);

    }
}
