package ast.visitor.nodes.php;
import Visitor.ASTVisitor;
import ast.visitor.Node;

import java.io.FileNotFoundException;

public class Php_pages extends Node {
    public String class_name = "Php_pages";
    private String controller_name;
    private String control_page_name;
    Controller_page controller_page;

    public void setControl_page_name(String control_page_name) {
        this.control_page_name = control_page_name;
    }

    public void setController_name(String controller_name) {
        this.controller_name = controller_name;
    }

    public void setController_page(Controller_page controller_page) {
        this.controller_page = controller_page;
    }

    public Controller_page getController_page() {
        return controller_page;
    }

    public String getControl_page_name() {
        return control_page_name;
    }

    public String getController_name() {
        return controller_name;
    }

    @Override
    public void accept(ASTVisitor astVisitor) throws FileNotFoundException {
        astVisitor.visit(this);
        if (controller_page != null)
        {
            this.controller_page.Controller_name = this.getController_name();
            this.controller_page.accept(astVisitor);

        }
        System.out.println("?>");
    }
}

