import Visitor.BaseASTVisitor;
import ast.visitor.BaseVisitor;
import ast.visitor.nodes.Programs;
import gen.HTMLLexer;
import gen.HTMLParser;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

import static org.antlr.v4.runtime.CharStreams.fromFileName;
public class Compiler {

    protected static void showGUI(ParseTree pt, HTMLParser parser) {
        Trees.inspect(pt, parser);
    }
    public static void main(String[] args) {
        try {
            PrintStream fileOut = new PrintStream("ErrorHandling.txt");
            PrintStream fileErr = new PrintStream("ContextError.txt");
            System.setOut(fileOut);
            System.setErr(fileErr);

            String source = "AST.txt";
            CharStream cs = fromFileName(source);
            HTMLLexer lexer = new HTMLLexer(cs);
            CommonTokenStream token  = new CommonTokenStream(lexer);
            HTMLParser parser = new HTMLParser(token);
            ParseTree tree = parser.programs();
//            showGUI(tree, parser);
            Programs doc = (Programs) new BaseVisitor().visit(tree);

            /////
//            for (int i = 0; i < doc.getPhp_arrayList().size(); i++) {
//                String name = doc.getPhp_arrayList().get(i).getControl_page_name();
//                for (int j = 0; j < doc.getHtml_arrayList().size(); j++) {
//                    if (Objects.equals(doc.getHtml_arrayList().get(i).getPage_name(), name))
//                    {
//                        doc.getHtml_arrayList().get(i).setControl_name(doc.getPhp_arrayList().get(i).getController_name());
//                    }
//                }
//            }
            /////
    //        System.out.println(BaseVisitor.SymbolTable);
      //      BaseVisitor.SymbolTable.PrintSymbolTable(BaseVisitor.SymbolTable);

            ///////////////////////////////////////////////////////////////////////////
         //   BaseVisitor.SymbolTable.GetControllerOfPage("p2");
            ///////////////////////////////////////////////////////////////////////////
            doc.accept(new BaseASTVisitor());
//            PrintStream  out =new PrintStream (new FileOutputStream("output.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
