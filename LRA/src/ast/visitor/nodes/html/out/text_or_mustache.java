package ast.visitor.nodes.html.out;

import Visitor.ASTVisitor;
import ast.visitor.Node;

public class text_or_mustache extends Node {
    public String class_name = "text_or_mustache";
    private String text;
    private String mustache;
    public String page_name;
    public void setText(String text) {
        this.text = text;
    }

    public void setMustache(String mustache) {
        this.mustache = mustache;
    }

    public String getText() {
        return text;
    }

    public String getMustache() {
        return mustache;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        if (text!=null)
        {
            System.out.print(this.text);
        }
        if (mustache != null)
        {
            System.out.print("<?php \nif(isset($_SESSION['"+this.page_name+"'])){\n" +
                    "\t$regValue = $_SESSION['"+this.page_name+"'];\n" +
                    "\tforeach ($regValue as $row) {\n" +
                    "\t\tprintf(\"%s,\", $row[\""+this.mustache+"\"]);\n" +
                    "\t}\n}" +
                    "\t?>");
        }
    }
}
