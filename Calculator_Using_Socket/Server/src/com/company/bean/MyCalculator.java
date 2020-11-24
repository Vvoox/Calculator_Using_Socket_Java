package com.company.bean;

import java.io.Serializable;

public class MyCalculator implements Serializable {

    private int num1;
    private int num2;
    private String operator;
    private static final long serialVersionUID = 1L;

    public MyCalculator(int num1, int num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public MyCalculator() {
    }

    @Override
    public String toString() {
        return "MyCalculator{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operator='" + operator + '\'' +
                '}';
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
