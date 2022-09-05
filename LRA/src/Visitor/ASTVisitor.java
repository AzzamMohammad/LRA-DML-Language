package Visitor;

import ast.visitor.nodes.html.*;
import ast.visitor.nodes.html.in.*;
import ast.visitor.nodes.html.out.*;
import ast.visitor.nodes.html.link.*;
import ast.visitor.nodes.php.*;
import ast.visitor.nodes.*;

import java.io.FileNotFoundException;


public interface ASTVisitor {

    public void visit(Programs p);

    public void visit(Php_pages s) throws FileNotFoundException;

    public void visit(Controller_page controllerPage);

    public void visit(Php_Element php_element);

    public void visit(Go go);

    public void visit(If anIf);

    public void visit(Insert insert);

    public void visit(ast.visitor.nodes.php.Select select);

    public void visit(Table table);

    public void visit(Valid valid);

    ///////////////////////////////
    public void visit(HtmlPages htmlPages) throws FileNotFoundException;

    public void visit(Pages p);

    public void visit(Element e);

    public void visit(Form form);

    public void visit(Body b);

    public void visit(Field f);

    public void visit(In i);

    public void visit(Option o);

    public void visit(ast.visitor.nodes.html.in.Select s);

    public void visit(ButtonLink b);

    public void visit(Link l);

    public void visit(SimpleLink s);

    public void visit(BigText b);

    public void visit(Img i);

    public void visit(List l);

    public void visit(Out o);

    public void visit(text_or_mustache t);

    public void visit(Textt t);


}
