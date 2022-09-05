package ast.visitor.nodes.html.in;

import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.util.ArrayList;

public class Select extends Node {
    public String class_name = "Select";
    private ArrayList<Option> optios;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setOptios(ArrayList<Option> optios) {
        this.optios = optios;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Option> getOptios() {
        return optios;
    }
    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        for (Option option : optios) {
            option.accept(astVisitor);
        }
        System.out.println("</select>");
    }
}
