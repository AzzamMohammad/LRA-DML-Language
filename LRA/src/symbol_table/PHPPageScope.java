package symbol_table;

public class PHPPageScope extends Scope{

    String controllerName;
    String htmlPageName;
    HTMLPageScope htmlPagePointer;

    String server;
    String user;
    String password;
    String db_name;

    public PHPPageScope(){
        this.setScopeName("PHPPageScope");
        this.server = "";
        this.user = "";
        this.db_name = "";
    }

    public String getControllerName() {
        return controllerName;
    }

    public String getHtmlPageName() {
        return htmlPageName;

    }

    public HTMLPageScope getHtmlPagePointer() {
        return htmlPagePointer;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
        this.setScopeName(controllerName);

    }

    public void setHtmlPageName(String htmlPageName) {
        this.htmlPageName = htmlPageName;
        Scope scope ;
        scope = this.getFatherScope();
        while (scope.getFatherScope() != null){
            scope = scope.getFatherScope();
        }
        scope = scope.getChild("HTMLScope");
//        System.out.println(scope.getScopeName());
        if(scope.getChild(htmlPageName) != null){
            HTMLPageScope scope1 = (HTMLPageScope) scope.getChild(htmlPageName);
            if(scope1.getControllerPointer() == null){
                scope1.ControllerPointer = this;
                this.htmlPagePointer = scope1;
//                this.htmlPagePointer.SetControllerPointer(this.controllerName);
            }else {
                ErrorNumber++;
                System.out.println("Error "+ErrorNumber+" in Controller " + this.getControllerName() + " in row " + this.getRow()+" : page can have only one controller");
            }

        }
        else {
            ErrorNumber++;
            System.out.println("Error "+ErrorNumber+" in Controller " + this.getControllerName() + " in row " + this.getRow() + " : Page " + htmlPageName + " not found.");

        }
    }

    public String getServer() {
        return server;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }
}
