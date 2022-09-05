package ast.visitor.nodes.html;

import Visitor.ASTVisitor;
import ast.visitor.Node;
import ast.visitor.nodes.php.Php_Element;
import ast.visitor.nodes.php.Valid;

import java.util.ArrayList;

public class Form extends Node {
    public String class_name = "Form";
    private ArrayList<Element> body;
    public String page_name;

    public void setBody(ArrayList<Element> body) {
        this.body = body;
    }

    public ArrayList<Element> getBody() {
        return body;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        for (Element element : body) {
            element.accept(astVisitor);
        }
        System.out.print("</form>\n");
    }
}
