package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        exp = exp.replaceAll("\\s+","");
	    Splitter splitter = new Splitter(Calculator.actions, exp);
        if(!splitter.isValid())
            throw new Exception("Invalid input");
        String action = splitter.getAction();
        Transformator transformator1 = TransformatorFactory.getTransformator(splitter.getValue1());
        Transformator transformator2 = TransformatorFactory.getTransformator(splitter.getValue2());
        if(transformator1.getType()!=transformator2.getType())
            throw new Exception("Different types of numbers");
        int number1 = transformator1.getResult();
        int number2 = transformator2.getResult();
        int result = Calculator.Calculate(number1,number2,action);
        if (transformator1.getType()==Types.ROME){
            String strResult = NumberSystemsUtils.IntToRome(result);
            System.out.println(exp+"="+strResult);
        } else {
            System.out.println(exp+"="+result);
        }
    }
}
