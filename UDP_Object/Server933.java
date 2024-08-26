/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_Object;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author buitu
 */
public class Server933 {
    public static void main(String[] args) {
        try{
            DatagramSocket server = new DatagramSocket(2209);
            System.out.println("Da khoi tao server !");
            while(true){
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                server.receive(receivePacket);
                ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
                ObjectInputStream ois = new ObjectInputStream(bais);
                Student933 student = (Student933) ois.readObject();
                System.out.println("Nhan duoc requets tu user: "+ student.getCode());
                
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(new Student933("sv1", student.getCode(), "BUI  tuaN  Nhat", ""));
                byte[] sendData = baos.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                server.send(sendPacket);
                
                byte[] resultData = new byte[1024];
                DatagramPacket resultPacket = new DatagramPacket(resultData, resultData.length);
                server.receive(resultPacket);
                ByteArrayInputStream bais1 = new ByteArrayInputStream(resultPacket.getData());
                ObjectInputStream ois1 = new ObjectInputStream(bais1);
                Student933 student1 = (Student933) ois1.readObject();
                System.out.println("Ket qua: "+ student1);
                
            }
        }catch(Exception e){
            System.out.println("Loi: "+e.toString());
        }
    }
}
