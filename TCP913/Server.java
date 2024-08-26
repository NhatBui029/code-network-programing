/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP913Bug;

import Model.Student;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author AD
 */
public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(1109);
        while (true) {
            Socket socket = serverSocket.accept();
            // nhận mã sinh viên được gửi đến từ client nhé.

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            String StrReceive = (String) objectInputStream.readObject();
            System.out.println("Nhận được: " + StrReceive.trim());

            // gửi đi Student
            Student student = new Student(12, "B16DCCN237", 4, "");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(student);

            System.out.println("Đã gửi đi student: " + student);
            // tính toán kết quả
            student.setGpaletter("A");
            // nhận kết quả từ client submit
            Student studentSubmit = (Student) objectInputStream.readObject();
//                studentSubmit = studentSubmit.trim();
            System.out.println("True Student : " + student);
            System.out.println("Nhận được Student: " + studentSubmit);

            // so sánh kết quả 2 student
            if (student.toString().equals(studentSubmit.toString())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        }

    }
}
