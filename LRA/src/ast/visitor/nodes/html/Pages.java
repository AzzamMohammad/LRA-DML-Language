package ast.visitor.nodes.html;

import Visitor.ASTVisitor;
import ast.visitor.Node;

public class Pages extends Node {
    public String class_name = "Pages";
    Body body;
    public String page_name;

    public void setBody(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return body;
    }
    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        System.out.println("<body>");
        if(body != null)
        {
            this.body.page_name = this.page_name;
            this.body.accept(astVisitor);
        }
        System.out.println("</body>");
    }
}
