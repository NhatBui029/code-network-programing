/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP933Object;

import Model933.Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
//        try {
            DatagramSocket server = new DatagramSocket(1109);
            System.out.println("Wait...");
            while (true) {
                //Nhan data
                byte[] dataReceive = new byte[1024];
                DatagramPacket dataPacket = new DatagramPacket(dataReceive, dataReceive.length);
                server.receive(dataPacket);

                //Chuyen sang Object
                ByteArrayInputStream bais = new ByteArrayInputStream(dataPacket.getData());
                ObjectInputStream in = new ObjectInputStream(bais);
                Student std = (Student) in.readObject();

                System.out.println("Du lieu sinh vien nhan duoc: " + std);

                //Tao data gui
                Student student = new Student("151", "B18DCCN250", "Nguyen Thi Hong", "");
                System.out.println("student; " + student);
                //Chuyen sang byte de gui
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(baos);
                out.writeObject(student);
                byte[] send = baos.toByteArray();

                DatagramPacket Send1 = new DatagramPacket(send, send.length, dataPacket.getAddress(), dataPacket.getPort());
                server.send(Send1);
                System.out.println("Gui thanh cong");

                //Nhan ve data
                //Nhan data
                byte[] dataReceive1 = new byte[1024];
                DatagramPacket dataPacket1 = new DatagramPacket(dataReceive1, dataReceive1.length);
                server.receive(dataPacket1);

                //Chuyen sang Object
                ByteArrayInputStream bais1 = new ByteArrayInputStream(dataPacket1.getData());
                ObjectInputStream in1 = new ObjectInputStream(bais1);
                Student std1 = (Student) in1.readObject();
                
 
            }
    }
}
