package symbol_table.elements.PHP;

import symbol_table.Scope;

import java.util.ArrayList;

public class SelectPhpScope extends Scope {
    private ArrayList<String> field ;
    private String tableName;

    public SelectPhpScope(){
        this.setScopeName("SelectScope");
    }

    public void setField(ArrayList<String> field) {
        this.field = field;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public ArrayList<String> getField() {
        return field;
    }

    public String getTableName() {
        return tableName;
    }
}
