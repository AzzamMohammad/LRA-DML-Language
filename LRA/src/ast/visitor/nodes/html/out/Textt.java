package ast.visitor.nodes.html.out;

import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Textt extends Node {
    public String class_name = "Textt";
    private String type;
    private ArrayList<text_or_mustache> text_or_mustaches = new ArrayList<>();
    public String page_name;

    public void setText_or_mustaches(ArrayList<text_or_mustache> text_or_mustaches) {
        this.text_or_mustaches = text_or_mustaches;
    }

    public ArrayList<text_or_mustache> getText_or_mustaches() {
        return text_or_mustaches;
    }



    public void setType(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        System.out.println("<"+this.type+">");
        for (text_or_mustache text_or_mustach : text_or_mustaches) {
            text_or_mustach.page_name = this.page_name;
            text_or_mustach.accept(astVisitor);
        }
        System.out.println("</"+this.type+">");

    }
}
