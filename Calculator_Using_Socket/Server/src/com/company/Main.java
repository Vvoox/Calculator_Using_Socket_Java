package com.company;

import com.company.bean.Message;
import com.company.bean.MyCalculator;
import com.company.service.DoCalcule;
import sample.bean.Operation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ListResourceBundle;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("Server Started");

        while (true){
            Socket socket = ss.accept();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Operation operation = (Operation) objectInputStream.readObject();

            System.out.println("Object received");
            System.out.println(operation.toString());
            String result = "";
            final List<String> numbersToBeReturn = operation.getNumbers();
            final List<String> operatorsToBeReturn = operation.getOperators();
            if(DoCalcule.verification(operation)){
                result = DoCalcule.calculation(operation.getNumbers(),operation.getOperators()).get(0);
            }
            else result = "Invalid input";
            operation.setNumbers(numbersToBeReturn);
            operation.setOperators(operatorsToBeReturn);
            operation.setResult(result);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(operation);
        }
        /*
        We don't need to close the socket while we're using infinite loop
         */
//        ss.close();
//        socket.close();

        }



}
