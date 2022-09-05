package symbol_table.elements.PHP;

import symbol_table.Scope;

public class IfPhpScope extends Scope {

    ValidPhpScope Condition;

    public IfPhpScope(){
        this.setScopeName("IfPhpScope");
    }

    public ValidPhpScope getCondition() {
        return Condition;
    }

    public void setCondition(ValidPhpScope condition) {
        Condition = condition;
    }
}
