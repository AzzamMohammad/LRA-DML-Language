package ast.visitor.nodes.html.out;

import Visitor.ASTVisitor;
import ast.visitor.Node;

public class Out extends Node {
    public String class_name = "In";
    BigText bigText;
    Img img;
    Textt textt;
    List list;
    public String page_name;

    public void setBigText(BigText bigText) {
        this.bigText = bigText;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setTextt(Textt textt) {
        this.textt = textt;
    }

    public BigText getBigText() {
        return bigText;
    }

    public Img getImg() {
        return img;
    }

    public List getList() {
        return list;
    }

    public Textt getTextt() {
        return textt;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        if (this.img != null) {
            this.img.accept(astVisitor);
        }
        if (this.bigText != null) {
            this.bigText.page_name = this.page_name;
            this.bigText.accept(astVisitor);
        }
        if (this.list != null) {
            this.list.page_name = this.page_name;
            this.list.accept(astVisitor);
        }
        if (this.textt != null) {
            this.textt.page_name = this.page_name;
            this.textt.accept(astVisitor);
        }

    }
}
