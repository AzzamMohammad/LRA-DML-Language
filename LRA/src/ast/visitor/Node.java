package ast.visitor;
import Visitor.ASTVisitor;
import ast.visitor.nodes.*;

import java.io.FileNotFoundException;

public class Node {
    public int line;
    public int col;

    public void setLine(int line) {
        this.line = line;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getLine() {
        return line;
    }

    public int getCol() {
        return col;
    }

    public void accept(ASTVisitor astVisitor) throws FileNotFoundException {

    }


}