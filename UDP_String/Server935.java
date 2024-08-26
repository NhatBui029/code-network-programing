/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_String;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*

 */
public class Server935 {
     public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(2208);
            System.out.println("Server khoi tao thanh cong!!");
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                server.receive(receivePacket);
                String request = new String(receivePacket.getData()).trim();
                System.out.println("Welcome: " + request + " with address: " + receivePacket.getAddress());

                String strInput = "1402;10;3,6,4,2,9,7";
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                System.out.println(clientAddress + ":" + clientPort);
                byte[] sendData = strInput.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                server.send(sendPacket);

                byte[] returnData = new byte[2048];
                DatagramPacket returnPacket = new DatagramPacket(returnData, returnData.length);
                server.receive(returnPacket);
                String result = new String(returnPacket.getData(),0,returnPacket.getLength()).trim();
                System.out.println("Ket qua: " + result);
            }
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
    }
}
