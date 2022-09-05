package ast.visitor.nodes.html.out;

import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.util.ArrayList;
import java.util.Map;

public class List extends Node {
    public String class_name = "List";
    private ArrayList<ArrayList<text_or_mustache>> optios;
    boolean numbered ;
    public String page_name;
    public void setNumbered(boolean numbered) {
        this.numbered = numbered;
    }

    public void setOptios(ArrayList<ArrayList<text_or_mustache>> optios) {
        this.optios = optios;
    }

    public ArrayList<ArrayList<text_or_mustache>> getOptios() {
        return optios;
    }

    public boolean getNumbered(){
        return numbered;
    }
    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        if (numbered)
        {
            System.out.println("<ol>");
            for (int i = 0; i < optios.size(); i++) {
                System.out.print("<li>");
                for (int j = 0; j < optios.get(i).size(); j++) {
                    optios.get(i).get(j).page_name = this.page_name;
                    optios.get(i).get(j).accept(astVisitor);
                }
                System.out.println("</li>");
            }
            System.out.println("</ol>");
        }
        else {
            System.out.println("<ul>");
            for (int i = 0; i < optios.size(); i++) {
                System.out.print("<li>");
                for (int j = 0; j < optios.get(i).size(); j++) {
                    optios.get(i).get(j).page_name = this.page_name;
                    optios.get(i).get(j).accept(astVisitor);
                }
                System.out.println("</li>");
            }
            System.out.println("</ul>");
        }

    }

}
