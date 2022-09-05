package ast.visitor.nodes.php;

import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.util.ArrayList;

public class Insert extends Node {
    public String class_name = "Insert";
    private ArrayList<String> fileds ;
    private String table_name;

    public void setFileds(ArrayList<String> fileds) {
        this.fileds = fileds;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public ArrayList<String> getFileds() {
        return fileds;
    }

    public String getTable_name() {
        return table_name;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
    }
}
