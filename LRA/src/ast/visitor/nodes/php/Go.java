package ast.visitor.nodes.php;

import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.util.ArrayList;

public class Go extends Node {
    public String class_name = "Go";
    private String page_name;
    private String role_name;
    private ArrayList<String> arrayList_field_role;

    public void setArrayList_field_role(ArrayList<String> arrayList_field_role) {
        this.arrayList_field_role = arrayList_field_role;
    }

    public ArrayList<String> getArrayList_field_role() {
        return arrayList_field_role;
    }

    public void setPage_name(String page_name) {
        this.page_name = page_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getPage_name() {
        return page_name;
    }

    public String getRole_name() {
        return role_name;
    }


    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
    }

}
