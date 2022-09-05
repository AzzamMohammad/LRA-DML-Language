package ast.visitor.nodes.html;

import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.util.ArrayList;

public class Body extends Node {
    public String class_name = "Body";
    ArrayList<Element> elements = new ArrayList<>();
    public String page_name;
    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        for (Element element : elements) {
            element.page_name = this.page_name;
            element.accept(astVisitor);
        }
    }
}
