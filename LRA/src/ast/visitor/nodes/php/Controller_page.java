package ast.visitor.nodes.php;

import ast.visitor.Node;
import ast.visitor.nodes.html.Element;
import Visitor.ASTVisitor;
import java.util.ArrayList;

public class Controller_page extends Node{
    public String class_name = "Controller_page";
    ArrayList<Php_Element> Element_arrayList = new ArrayList<>();
    public String Controller_name;

    public void setElement_arrayList(ArrayList<Php_Element> element_arrayList) {
        Element_arrayList = element_arrayList;
    }

    public ArrayList<Php_Element> getElement_arrayList() {
        return Element_arrayList;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        for (Php_Element php_element : Element_arrayList) {
            php_element.Controller_name = this.Controller_name;
            php_element.accept(astVisitor);
        }

    }
}
