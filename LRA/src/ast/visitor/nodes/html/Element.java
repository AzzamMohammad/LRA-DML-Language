package ast.visitor.nodes.html;

import Visitor.ASTVisitor;
import ast.visitor.Node;
import ast.visitor.nodes.html.in.In;
import ast.visitor.nodes.html.link.Link;
import ast.visitor.nodes.html.out.Out;

public class Element extends Node {
    public String class_name = "Element";
    In in;
    Out out;
    Link link;
    Form form;
    public String page_name;

    public void setForm(Form form) {
        this.form = form;
    }

    public Form getForm() {
        return form;
    }

    public void setIn(In in) {
        this.in = in;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public void setOut(Out out) {
        this.out = out;
    }

    public In getIn() {
        return in;
    }

    public Link getLink() {
        return link;
    }

    public Out getOut() {
        return out;
    }
    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        if (in!=null)
        {
            this.in.accept(astVisitor);
        }
        if (out != null) {
            this.out.page_name = this.page_name;
            this.out.accept(astVisitor);
        }
        if (link != null)
        {
            this.link.accept(astVisitor);
        }
        if (form != null)
        {
            this.form.page_name = this.page_name;
            this.form.accept(astVisitor);
        }
    }
}
