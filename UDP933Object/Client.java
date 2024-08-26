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
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class Client {
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
//        try {
            DatagramSocket client = new DatagramSocket();
            //Ma sv
            Student std = new Student("B18DCCN250");
            //Chuyen sang byte
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(std);

            byte[] send1 = baos.toByteArray();
            DatagramPacket packet1 = new DatagramPacket(send1, send1.length, InetAddress.getByName("127.0.0.1"), 1109);
            client.send(packet1);

            //Nhan ve Data
            byte[] buf = new byte[1024];
            DatagramPacket nhan = new  DatagramPacket(buf, buf.length);
            client.receive(nhan);

            //Chuyen qua Object
            ByteArrayInputStream bais = new ByteArrayInputStream(nhan.getData());
            ObjectInputStream in = new ObjectInputStream(bais);
            Student student = (Student)in.readObject();
            //Xu ly data
            String ten = student.getName();
            String[] s = ten.split(" ");
            String Ten = "";
            for (int i = 0; i < s.length; i++) {
                Ten += s[i].substring(0, 1).toUpperCase() + s[i].substring(1, s[i].length()).toLowerCase() + " ";
            }
            Ten = Ten.trim();
            student.setName(Ten);
            System.out.println("Name: " + Ten);

            //Tao email
            int m = s.length-1;
            String email1 = s[m].toLowerCase();
            for (int i = 0; i < m ; i++) {
                email1 += s[i].substring(0, 1).toLowerCase();
            }
            email1 += "@ptit.edu.vn";

            System.out.println("Email: " + email1);
            student.setEmail(email1);
            System.out.println("KQ: " + student);
            //Chuyen sang byte de gui

            out.writeObject(student);
            byte[] send = baos.toByteArray();
            DatagramPacket Send1 = new DatagramPacket(send, send.length, InetAddress.getByName("127.0.0.1"), 1109);
            client.send(Send1);
}
    
}
