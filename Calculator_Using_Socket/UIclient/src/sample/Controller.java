package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import sample.bean.Operation;
import sample.service.SendToServer;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    @FXML
    private TextArea input,output;

    private List<String> operator = Arrays.asList("+","-","*","/");
    private List<String> nmb = Arrays.asList("0","1","2","3","4","5","6","7","8","9");

    public void showInText(ActionEvent actionEvent) {
        int legnth = actionEvent.getSource().toString().length();
        String number = actionEvent.getSource().toString().substring(legnth-2,legnth-1);
        input.setText(input.getText()+number);
    }

    public void getTextInputAndFiltreIt() throws IOException, ClassNotFoundException {
        try{
            List<String> numbers = new ArrayList<>();
            List<String> all = new ArrayList<>();
            List<String> operators = new ArrayList<>();
            List<String> finalNumber = new ArrayList<>();
            String[] tab = input.getText().split("");
            for(String e :tab) all.add(e);
            all.forEach(element->{
                operator.forEach(op ->{
                    if(element.equals(op)){
                        operators.add(element);
                        numbers.add("|");
                    }
                });
                nmb.forEach(n->{
                    if(element.equals(n)){
                        numbers.add(element);
                    }
                });
            });
            String res = "";
            for(String e :numbers) res += e;
            String[] listFinal = res.split("\\|");
            for(String e  : listFinal) finalNumber.add(e);
            finalNumber.forEach(System.out::println);


            Operation operation = new Operation(finalNumber, operators);
            Operation result = SendToServer.send(operation);
            output.setText(result.getResult());

        }catch (Exception e){
            System.out.println("Error : "+e.getMessage());
            output.setText(e.getMessage());
        }
    }

    public void clearInputAndOutput(){
        input.clear();
        output.clear();
    }

}
