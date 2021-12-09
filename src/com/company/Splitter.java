package com.company;

import java.util.Collection;
import java.util.Vector;

public class Splitter {
    boolean valid;
    String[] actions;
    String value1, value2;
    String expression;
    String action;

    /**
     *
     * @param actions - string array contains all symbols which can be used like operators
     * @param expression - string with math expression, contains two operands and one operator
     */
    public Splitter(String[] actions, String expression){
        this.expression = expression;
        this.actions = actions;
        valid = false;
        Split();
    }

    public String getAction() {
        return action;
    }

    public boolean isValid() {
        return valid;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    void Split(){
        for (String regex : actions){
            int regexIndex = expression.indexOf(regex);
            if(regexIndex>0 && regexIndex < expression.length()-1){
                value1 = expression.substring(0,regexIndex);
                value2 = expression.substring(regexIndex+1, expression.length());
                valid = true;
                action = regex;
            }
        }
    }
    
}
