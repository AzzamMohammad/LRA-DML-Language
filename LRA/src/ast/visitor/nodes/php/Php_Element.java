package ast.visitor.nodes.php;

import ast.visitor.Node;
import Visitor.ASTVisitor;

import java.util.Objects;

public class Php_Element extends Node {
    public String class_name = "Php_Element";
    public String Controller_name;
    Insert insert;
    Select select;
    Valid valid;
    Go go;
    If anIf;
    String server="";
    String user="";
    String password;
    String db_name="";

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDb_name() {
        return db_name;
    }

    public String getPassword() {
        return password;
    }

    public String getServer() {
        return server;
    }

    public String getUser() {
        return user;
    }

    public void setAnIf(If anIf) {
        this.anIf = anIf;
    }

    public If getAnIf() {
        return anIf;
    }

    public void setGo(Go go) {
        this.go = go;
    }

    public Go getGo() {
        return go;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public void setInsert(Insert insert) {
        this.insert = insert;
    }

    public void setValid(Valid valid) {
        this.valid = valid;
    }

    public Select getSelect() {
        return select;
    }

    public Insert getInsert() {
        return insert;
    }

    public Valid getValid() {
        return valid;
    }

    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        if (!Objects.equals(this.getServer(), ""))
        {
            System.out.println("$servername = '"+this.getServer()+"';");
        }
        if (!Objects.equals(this.getUser(), ""))
        {
            System.out.println("$username = '"+this.getUser()+"';");
        }
        if (this.getPassword() != null)
        {
            System.out.println("$password = '"+this.getPassword()+"';");
        }
        if (!Objects.equals(this.getDb_name(), ""))
        {
            System.out.println("$dbname = '"+this.getDb_name()+"';");
        }

        if (insert != null)
        {
            insert.accept(astVisitor);
        }
        if (select != null)
        {
            select.Controller_name = this.Controller_name;
            select.accept(astVisitor);
        }
        if (valid != null)
        {
            valid.accept(astVisitor);
        }
        if (go != null)
        {
            go.accept(astVisitor);
        }
        if (anIf != null)
        {
            anIf.accept(astVisitor);
        }
    }
}
