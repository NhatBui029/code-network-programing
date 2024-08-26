/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_String;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author buitu
 */
public class Client801 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            
            byte[] sendByte = "B20DCCN029;801".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendByte, sendByte.length, InetAddress.getByName("localhost"),2208);
            socket.send(sendPacket);
            
            byte[] buf = new byte[1024];
            DatagramPacket bufPacket = new DatagramPacket(buf, buf.length);
            socket.receive(bufPacket);
            String bufStr = new String(bufPacket.getData());
            String[] bufArr = bufStr.trim().split(("\\;"));
            String requestID = bufArr[0];
            int n = Integer.parseInt(bufArr[1]);
            String[] a = bufArr[2].trim().split("\\,");
            List<Integer> input = new ArrayList<>();
            for(String s: a) input.add(Integer.parseInt(s));
            
            List<Integer> list = new ArrayList<>();
            for(int i =1;i<=n;i++) list.add(i);
            list.sort(Collections.reverseOrder());
            
            list.removeAll(input);
            String result = requestID+";";
            for(int i: list) result += Integer.toString(i)+",";
            System.out.println(result);
            
            byte[] resultByte = result.substring(0, result.length()-1).getBytes();
            DatagramPacket resultPacket = new DatagramPacket(resultByte, resultByte.length, InetAddress.getByName("localhost"),2208);
            socket.send(resultPacket);
            
            
        } catch (Exception e) {
        }
    }
}
