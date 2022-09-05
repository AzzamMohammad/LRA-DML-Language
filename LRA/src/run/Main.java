package run;

import ast.visitor.BaseVisitor;
import ast.visitor.nodes.Programs;
import gen.HTMLLexer;
import gen.HTMLParser;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main{
    //public static SimpleTable symbolTable = new SimpleTable();


    protected static void showGUI(ParseTree pt, HTMLParser parser) {
        Trees.inspect(pt, parser);
    }
    public static void main(String[] args) {

        try {
            String source = "AST.txt";
            CharStream cs = fromFileName(source);
            HTMLLexer lexer = new HTMLLexer(cs);
            CommonTokenStream token  = new CommonTokenStream(lexer);
            HTMLParser parser = new HTMLParser(token);
            ParseTree tree = parser.programs();
            // showGUI(tree, parser);

            Programs doc = (Programs) new BaseVisitor().visit(tree);


            PrintStream  out =new PrintStream (new FileOutputStream("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
