package ast.visitor.nodes.html.link;


import Visitor.ASTVisitor;
import ast.visitor.Node;

public class Link extends Node {
    public String class_name = "Link";
    ButtonLink buttonLink;
    SimpleLink simpleLink;

    public void setButtonLink(ButtonLink buttonLink) {
        this.buttonLink = buttonLink;
    }

    public void setSimpleLink(SimpleLink simpleLink) {
        this.simpleLink = simpleLink;
    }

    public ButtonLink getButtonLink() {
        return buttonLink;
    }

    public SimpleLink getSimpleLink() {
        return simpleLink;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        if (buttonLink!=null)
        {
            this.buttonLink.accept(astVisitor);
        }
        if (simpleLink!=null){
            this.simpleLink.accept(astVisitor);
        }
    }
}
