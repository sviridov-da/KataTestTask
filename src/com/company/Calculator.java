package com.company;

public class Calculator {
    /**
     * array of valid operation
     */
    public static String[] actions = {"+","-","/","*"};

    /**
     *
     * @param val1 - operand #1
     * @param val2 - operand #2
     * @param action - operator
     * @return - return result of calculation of the operation action between val1 and val2
     */
    public static int Calculate(int val1, int val2, String action){
        int result = 0;
        switch (action){
            case "+":
                result = val1+val2;
                break;
            case "-":
                result = val1-val2;
                break;
            case "*":
                result = val1*val2;
                break;
            case "/":
                result = val1/val2;
                break;
            default:
                result =0;
        }
        return result;
    }
}
