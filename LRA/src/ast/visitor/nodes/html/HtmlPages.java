package ast.visitor.nodes.html;

import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HtmlPages extends Node {
    public String class_name = "HtmlPages";
    private String page_name = "";
    private String control_name = "";
    private ArrayList<String> extend_pages;
    Pages pages;


    public void setControl_name(String control_name) {
        this.control_name = control_name;
    }

    public String getControl_name() {
        return control_name;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public Pages getPages() {
        return pages;
    }

    public void setPage_name(String page_name) {
        this.page_name = page_name;
    }

    public void setExtend_pages(ArrayList<String> extend_pages) {
        this.extend_pages = extend_pages;
    }

    public String getPage_name() {
        return page_name;
    }

    public ArrayList<String> getExtend_pages() {
        return extend_pages;
    }

    @Override
    public void accept(ASTVisitor astVisitor) throws FileNotFoundException {
        astVisitor.visit(this);
        System.out.println("<?php\nsession_start();\n?>");
        System.out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\t<title>Document</title>\n" +
                "</head>\n");
        if (pages != null) {
            this.pages.page_name = this.page_name;
            this.pages.accept(astVisitor);
        }
        System.out.println("</html>");
    }

}
