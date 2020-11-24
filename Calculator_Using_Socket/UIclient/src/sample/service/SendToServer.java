package sample.service;

import sample.Controller;
import sample.bean.Operation;

import java.io.*;
import java.net.Socket;

public class SendToServer {

    public static Operation send(Operation operation) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("localhost",7777);

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(operation);

        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Operation result = (Operation) objectInputStream.readObject();

        result.setNumbers(operation.getNumbers());
        result.setOperators(operation.getOperators());
        System.out.println(result.toString());

        socket.close();
        return result;

    }
//    public static void checkIfServerAlive() throws IOException {
//        Socket socket = new Socket("localhost",7777);
//        boolean outputStream = socket.isOutputShutdown();
//        System.out.println(outputStream);
//       InputStream  inputStream = socket.getInputStream();
//       InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//    }
}
