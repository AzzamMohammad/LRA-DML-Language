package symbol_table.elements.PHP;

import symbol_table.Scope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GoPhpScope extends Scope {

    private String pageName;
    private String roleName;
    private ArrayList<String> arrayListFieldRole;

    public GoPhpScope(){
        this.setScopeName("GoPhpScope");
        this.roleName = "";
        this.arrayListFieldRole = null;
    }

    public String getPageName() {
        return pageName;
    }

    public String getRoleName() {
        return roleName;
    }

    public ArrayList<String> getArrayListFieldRole() {
        return arrayListFieldRole;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
        Scope scope = this.getFatherScope();
        String ControllerName = "";
        while (scope.getFatherScope() != null){
            if(scope.getFatherScope().getScopeName().equals("PHPScope"))
                ControllerName = scope.getScopeName();
            scope=scope.getFatherScope();
        }

        scope=scope.getChild("HTMLScope");
        Scope HtmlPage = scope.getChild(this.pageName);
        if(HtmlPage == null){
            ErrorNumber++;
            System.out.println("Error "+ErrorNumber+" in controller "+ControllerName+" in row "+this.getRow()+" : Page "+this.pageName+" not exists");
        }
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setArrayListFieldRole(ArrayList<String> arrayListFieldRolee) {
        this.arrayListFieldRole = arrayListFieldRolee;
    }
}
