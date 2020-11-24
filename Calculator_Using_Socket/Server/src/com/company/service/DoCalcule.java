package com.company.service;

import sample.bean.Operation;

import java.util.List;

public class DoCalcule {


    //Still need Exceptions for operators {/,*}
    public static List<String> calculation(List<String> list,List<String> operator){
        try {
            while (list.size() != 1) {
                    double num1 = Double.parseDouble(list.get(0));
                    double num2 = Double.parseDouble(list.get(1));
                    double res = 0;
                    String op = operator.get(0);
                    switch (op) {
                        case "+":
                            res = num1 + num2;
                            break;
                        case "-":
                            res = num1 - num2;
                            break;
                        case "*":
                            res = num1 * num2;
                            break;
                        case "/":
                            res = num1 / num2;
                            break;
                    }
                    list.remove(0);
                    list.set(0, Double.toString(res));
                    operator.remove(0);
                    calculation(list, operator);
                }
        }catch(Exception e){
            list.add("ERROR");
        }
        return list;
    }

    public static boolean verification(Operation operation){
        if(operation.getOperators().size()<operation.getNumbers().size()){
            return true;
        }
        else return false;
    }
}
