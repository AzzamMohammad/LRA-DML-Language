package ast.visitor.nodes.php;

import ast.visitor.Node;
import Visitor.ASTVisitor;
import java.util.ArrayList;

public class Select extends Node {
    public String class_name = "Select";
    private ArrayList<String> fileds ;
    private String table_name;
    public String Controller_name;

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
