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
import java.net.Socket;

/**
 *
 * @author AD
 */
public class Client {
     public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("127.0.0.1", 1109);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        //Gui ma SV
        out.writeObject("B18DCCN250;913");
        System.out.println("Gui thanh cong");

        //Nhan sinh vien
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Student student = (Student) in.readObject();
        System.out.println("Sinh vien nhan duoc: " + student);

        //Xu ly chuyen doi
        float gpa = student.getGpa();
        if (3.7 <= gpa && gpa <= 4.0) {
            student.setGpaletter("A");
        } else {
            if (3.0 <= gpa && gpa < 3.7) {
                student.setGpaletter("B");
            } else {
                if (2.0 <= gpa && gpa < 3.0) {
                    student.setGpaletter("C");
                } else {
                    if (1.0 <= gpa && gpa < 2.0) {
                        student.setGpaletter("D");
                    } else {
                        student.setGpaletter("F");
                    }
                }
            }
        }

        //Gui data di
        System.out.println("Ket qua: " + student);
        out.writeObject(student);
        socket.close();

    }
}
