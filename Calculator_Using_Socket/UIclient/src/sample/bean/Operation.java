package sample.bean;

import java.io.Serializable;
import java.util.List;

public class Operation implements Serializable {
    private List<String> Numbers;
    private List<String> operators;
    private String result;
    private static final long serialVersionUID = 1L;

    public List<String> getNumbers() {
        return Numbers;
    }

    public void setNumbers(List<String> numbers) {
        Numbers = numbers;
    }

    public List<String> getOperators() {
        return operators;
    }

    public void setOperators(List<String> operators) {
        this.operators = operators;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Operation(List<String> numbers, List<String> operators) {
        Numbers = numbers;
        this.operators = operators;
    }

    public Operation(int[] ints, String[] strings) {
    }

    @Override
    public String toString() {
        return "Operation{" +
                "Numbers=" + Numbers +
                ", operators=" + operators +
                ", result='" + result + '\'' +
                '}';
    }
}
