package ast.visitor.nodes.html.in;

import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.util.ArrayList;

public class In extends Node {
    public String class_name = "In";
    Field field;
    Select select;

    public void setField(Field field) {
        this.field = field;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public Field getField() {
        return field;
    }

    public Select getSelect() {
        return select;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        if (field != null)
        {
            this.field.accept(astVisitor);
        }
        if (select != null)
        {
            this.select.accept(astVisitor);
        }
    }
}
