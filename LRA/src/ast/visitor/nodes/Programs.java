package ast.visitor.nodes;

import Visitor.ASTVisitor;
import ast.visitor.Node;
import ast.visitor.nodes.html.HtmlPages;
import ast.visitor.nodes.php.Php_pages;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Programs extends Node {
    public String class_name = "Programs";
    ArrayList<HtmlPages> html_arrayList = new ArrayList<>();
    ArrayList<Php_pages> php_arrayList = new ArrayList<>();

    public void setHtml_arrayList(ArrayList<HtmlPages> html_arrayList) {
        this.html_arrayList = html_arrayList;
    }

    public void setPhp_arrayList(ArrayList<Php_pages> php_arrayList) {
        this.php_arrayList = php_arrayList;
    }

    public ArrayList<HtmlPages> getHtml_arrayList() {
        return html_arrayList;
    }

    public ArrayList<Php_pages> getPhp_arrayList() {
        return php_arrayList;
    }

    @Override
    public void accept(ASTVisitor astVisitor) throws FileNotFoundException {
        astVisitor.visit(this);
        for (HtmlPages htmlPages: html_arrayList){
            htmlPages.accept(astVisitor);
        }

        for (Php_pages php_pages : php_arrayList) {
            php_pages.accept(astVisitor);
        }




    }
}
