package Visitor;

import ast.visitor.BaseVisitor;
import ast.visitor.nodes.*;
import ast.visitor.nodes.html.*;
import ast.visitor.nodes.html.in.Field;
import ast.visitor.nodes.html.in.In;
import ast.visitor.nodes.html.in.Option;
import ast.visitor.nodes.html.link.ButtonLink;
import ast.visitor.nodes.html.link.Link;
import ast.visitor.nodes.html.link.SimpleLink;
import ast.visitor.nodes.html.out.*;
import ast.visitor.nodes.php.*;
import org.w3c.dom.ls.LSOutput;
import symbol_table.Scope;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BaseASTVisitor implements ASTVisitor {
    static int count = 0;
    static int count_input = 0;

    @Override
    public void visit(Programs p) {

    }

    @Override
    public void visit(Php_pages s) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(s.getController_name() + ".php"));
        System.setOut(out);
        System.out.println("<?php");
    }

    @Override
    public void visit(Controller_page controllerPage) {

    }

    @Override
    public void visit(Php_Element php_element) {

    }

    @Override
    public void visit(Go go) {
        System.out.println("if($result != null){");
        System.out.println("session_start();");
        System.out.println("$a = $result->fetch_all(MYSQLI_BOTH);\n" +
                "$_SESSION[\""+go.getPage_name()+"\"] = $a;");
        System.out.println("}");
        if(go.getPage_name() !=null && go.getRole_name()==null)
        {
            System.out.println("header('Location: http://localhost:8080/"+go.getPage_name()+".php');");
            System.out.println("exit();");
        }
        if(go.getPage_name() !=null && go.getRole_name()!=null)
        {
            for (int i = 0; i < go.getArrayList_field_role().size(); i++) {
                System.out.println("$rol"+i+"="+"$_POST['"+go.getArrayList_field_role().get(i)+"']"+";");
            }

            StringBuilder role= new StringBuilder();
            for (int i = 0; i < go.getArrayList_field_role().size(); i++) {
                if (i!=0){
                    role.append("AND ");
                }
                role.append(go.getArrayList_field_role().get(i)).append("=").append("'").append("$rol").append(i).append("' ");
            }
            System.out.println("\n" +
                    "$conn = new mysqli($servername, $username, $password, $dbname);\n" +
                    "// Check connection\n" +
                    "if ($conn->connect_error) {\n" +
                    "  die(\"Connection failed: \" . $conn->connect_error);\n" +
                    "}\n" +
                    "\n" +
                    "$sql_role = \"SELECT role FROM users WHERE "+role+";\";\n" +
                    "$role = $conn->query($sql_role);\n" +
                    "$row_role = $role->fetch_assoc();\n$conn->close();\n" +
                    "if($row_role != null){\n" +
                    "  if($row_role[\"role\"] == '"+go.getRole_name()+"')\n{");
            System.out.println("header('Location: http://localhost:8080/"+go.getPage_name()+".php');");
            System.out.println("exit();}\n}");

        }

    }

    @Override
    public void visit(If anIf) {
        int c = count;
        System.out.println("if(a"+(c-1)+"())\n{");
    }

    @Override
    public void visit(Insert insert) {
        if (insert.getFileds() != null) {
            StringBuilder allFileds = new StringBuilder();
            for (int i = 0; i < insert.getFileds().size(); i++) {
                allFileds.append(insert.getFileds().get(i));
                if (i != insert.getFileds().size() - 1)
                    allFileds.append(",");
            }

            StringBuilder Fileds = new StringBuilder();
            for (int i = 0; i < insert.getFileds().size(); i++) {
                System.out.println("$field"+i+"="+"$_POST['"+insert.getFileds().get(i)+"']"+";");
                Fileds.append("'$field").append(i).append("'");
                if (i != insert.getFileds().size() - 1)
                    Fileds.append(",");
            }

            System.out.println("$conn = new mysqli($servername, $username, $password, $dbname);\n" +
                    "// Check connection\n" +
                    "if ($conn->connect_error) {\n" +
                    "  die(\"Connection failed: \" . $conn->connect_error);\n" +
                    "}\n" +
                    "\n" +
                    "$sql = \"INSERT INTO " + insert.getTable_name() + " ("+allFileds+")\n" +
                    "VALUES ("+Fileds+")\";\n" +
                    "\n" +
                    "if ($conn->query($sql) === TRUE) {\n" +
                    "  echo \"New record created successfully\";\n" +
                    "} else {\n" +
                    "  echo \"Error: \" . $sql . \"<br>\" . $conn->error;\n" +
                    "}\n" +
                    "\n" +
                    "$conn->close();");
        }
    }

    @Override
    public void visit(Select select) {
        if (select.getFileds() != null)
        {
            StringBuilder allFileds = new StringBuilder();
            for (int i = 0; i < select.getFileds().size(); i++) {
                allFileds.append(select.getFileds().get(i));
                if (i != select.getFileds().size() - 1)
                    allFileds.append(",");
            }


            System.out.println("$conn = new mysqli($servername, $username, $password, $dbname);\n" +
                    "// Check connection\n" +
                    "if ($conn->connect_error) {\n" +
                    "  die(\"Connection failed: \" . $conn->connect_error);\n" +
                    "}\n" +
                    "\n" +
                    "$sql = \"SELECT "+allFileds+" FROM "+select.getTable_name()+"\";\n" +
                    "$result = $conn->query($sql);"+"\n" +
                    "$conn->close();");

        }
    }

    @Override
    public void visit(Table table) {

    }

    @Override
    public void visit(Valid valid) {
        if (valid.getFileds() != null) {
            StringBuilder allFileds = new StringBuilder();
            for (int i = 0; i < valid.getFileds().size(); i++) {
                allFileds.append(valid.getFileds().get(i));
                if (i != valid.getFileds().size() - 1)
                    allFileds.append(",");
            }
            StringBuilder all = new StringBuilder();
            for (int i = 0; i < valid.getFileds().size(); i++) {
                all.append(valid.getFileds().get(i)).append("=").append("'$field").append(i).append("'");
                if (i != valid.getFileds().size() - 1)
                    all.append(" AND ");
            }
//            StringBuilder Fileds = new StringBuilder();
//            for (int i = 0; i < valid.getFileds().size(); i++) {
//                Fileds.append(valid.getFileds().get(i)).append("=").append("'$_POST['").append(valid.getFileds().get(i)).append("']'");
//                if (i != valid.getFileds().size() - 1)
//                    Fileds.append(",");
//            }

            System.out.println("function a"+count+"(){\n");
            count++;
            for (int i = 0; i < valid.getFileds().size(); i++) {
                System.out.println("$field"+i+"="+"$_POST['"+valid.getFileds().get(i)+"']"+";");
            }
            System.out.println("$conn = new mysqli($GLOBALS['servername'], $GLOBALS['username'], $GLOBALS['password'], $GLOBALS['dbname']);\n" +
                    "// Check connection\n" +
                    "if ($conn->connect_error) {\n" +
                    "  die(\"Connection failed: \" . $conn->connect_error);\n" +
                    "}\n" +
                    "\n" +
                    "$sql = \"SELECT "+allFileds+" FROM "+valid.getTable_name()+" WHERE "+all+"\";\n" +
                    "$result = $conn->query($sql);\nif ($result->num_rows > 0)\n{\nreturn true;\n}else\nreturn false;" );
            System.out.println("}");
        }
    }

    @Override
    public void visit(HtmlPages htmlPages) throws FileNotFoundException {
        PrintStream a = new PrintStream(new FileOutputStream(htmlPages.getPage_name() + ".php"));
        System.setOut(a);
    }

    @Override
    public void visit(Pages p) {

    }

    @Override
    public void visit(Element e) {

    }

    @Override
    public void visit(Form form) {
        System.out.print("<form action=\""+BaseVisitor.SymbolTable.GetControllerOfPage(form.page_name).getScopeName()+".php\" method=\"post\">\n");
    }

    @Override
    public void visit(Body b) {

    }

    @Override
    public void visit(Field f) {
        String all = "";
        if (f.getType() != null){
            all = all +"type=\""+f.getType()+"\"";
        }
        if (f.getName() != null)
        {
            all = all +" name=\""+f.getName()+"\"";
        }
        if (f.getRequired())
        {
            all = all + " required";
        }
        if (f.getHint() != null)
        {
           all = all + " placeholder=\"" + f.getHint()+"\"";
        }
        if (f.getText() != null)
        {
            System.out.println("<label for=\""+count_input+"\">"+f.getText()+"</label>");
            all = all + " id=\""+count_input+"\"";
            count_input++;
        }
        System.out.println("<input "+all+">");
    }

    @Override
    public void visit(In i) {

    }

    @Override
    public void visit(Option o) {
        System.out.print("<option ");
        if(o.getValue()!=null)
        {
            System.out.print("value=\""+o.getValue()+"\"");
        }
        System.out.print(">");
        if (o.getTitle()!=null)
        {
            System.out.print(o.getTitle());
        }
        System.out.print("</option>\n");

    }

    @Override
    public void visit(ast.visitor.nodes.html.in.Select s) {
        System.out.print("<select ");
           if (s.getName()!=null){
               System.out.print("name=\""+s.getName()+"\"");
           }
        System.out.print(">\n");
    }

    @Override
    public void visit(ButtonLink b) {
        String href = "",text ="";
        if (b.getHref()!=null)
        {
            href=b.getHref();
        }
        if (b.getText()!=null)
        {
            text = b.getText();
            System.out.println("<a href='"+href+"'>\n" +
                    "        <button style=\"min-width: 40px;min-height: 20px;\">\n" +
                    "            "+text+"\n" +
                    "        </button>\n" +
                    "    </a>");
        }else
            System.out.println("<a href='"+href+"'>\n" +
                    "        <button style=\"min-width: 40px;min-height: 20px;\">\n" +
                    "            "+"click"+"\n" +
                    "        </button>\n" +
                    "    </a>");

    }

    @Override
    public void visit(Link l) {

    }

    @Override
    public void visit(SimpleLink s) {
        String href = "",text ="";
        if (s.getHref()!=null)
        {
            href=s.getHref();
        }
        if (s.getText()!=null)
        {
            text = s.getText();
            System.out.println("<a href='"+href+"'>"+text+"</a>");
        }else
            System.out.println("<a href='"+href+"'>"+href+"</a>");

    }

    @Override
    public void visit(BigText b) {

    }

    @Override
    public void visit(Img i) {
       if (i.getAlt_text()!=null)
       {
           System.out.println("<img src=\""+i.getPath()+"\" alt=\""+i.getAlt_text()+"\">");
       }else
           System.out.println("<img src=\""+i.getPath()+"\">");
    }

    @Override
    public void visit(List l) {

    }

    @Override
    public void visit(Out o) {

    }

    @Override
    public void visit(text_or_mustache t) {

    }

    @Override
    public void visit(Textt t) {

    }
}
