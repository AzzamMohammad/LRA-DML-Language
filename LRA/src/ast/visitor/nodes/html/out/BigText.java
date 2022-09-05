package ast.visitor.nodes.html.out;

import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BigText extends Node {
    public String class_name = "BigText";

    private String scale;
    private ArrayList<text_or_mustache> text_or_mustaches = new ArrayList<>();
    public String page_name;

    public void setText_or_mustaches(ArrayList<text_or_mustache> text_or_mustaches) {
        this.text_or_mustaches = text_or_mustaches;
    }

    public ArrayList<text_or_mustache> getText_or_mustaches() {
        return text_or_mustaches;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }



    public String getScale() {
        return scale;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        System.out.println("<h"+this.getScale()+">");
        for (text_or_mustache text_or_mustach : text_or_mustaches) {
            text_or_mustach.page_name = this.page_name;
            text_or_mustach.accept(astVisitor);
        }
        System.out.println("</h"+this.getScale()+">");
    }
}
