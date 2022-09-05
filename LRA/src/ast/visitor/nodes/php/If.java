package ast.visitor.nodes.php;

import ast.visitor.Node;
import Visitor.ASTVisitor;
import java.util.ArrayList;

public class If extends Node {
    public String class_name = "If";
    private Valid condition;
    private ArrayList<Php_Element> body;

    public void setBody(ArrayList<Php_Element> body) {
        this.body = body;
    }

    public void setCondition(Valid condition) {
        this.condition = condition;
    }

    public ArrayList<Php_Element> getBody() {
        return body;
    }

    public Valid getCondition() {
        return condition;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        if (condition!=null)
        {
            condition.accept(astVisitor);
        }
        astVisitor.visit(this);
        for (Php_Element php_element : body) {
            php_element.accept(astVisitor);
        }
        System.out.println("}");
    }
}
