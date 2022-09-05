package ast.visitor.nodes.php;

import ast.visitor.Node;
import Visitor.ASTVisitor;
public class Table extends Node {
    public String class_name = "Table";
    private String table_name;

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getTable_name() {
        return table_name;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {

    }
}
