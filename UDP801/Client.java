/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP801;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author AD
 */
public class Client {
    public static void main(String args[]) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        String str = ";B18DCCN250;801";
        DatagramPacket dqReq = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 2207);
        client.send(dqReq);

        //nhan du lieu tu server 
        byte buf[] = new byte[1024];
        DatagramPacket dqRes = new DatagramPacket(buf, buf.length);
        client.receive(dqRes);
        System.out.println(new String(dqRes.getData()));

        //xu ly
        String s = new String(dqRes.getData());
        String[] s1 = s.split(";");
        int n = Integer.parseInt(s1[1].trim());
        StringBuilder xau = new StringBuilder(s1[0] + ";");
        boolean t = false;
        for (int i = 1; i <= n; i++) {
            if (!s1[2].contains(i + "")) {
                xau.append(i + ",");
                t = true;
            }
        }
        String result = xau.toString();
        
        if(t){
            result = result.substring(0, xau.length() - 1);
        }

        //gui len server
        byte[] b = result.getBytes();
        dqReq = new DatagramPacket(b, b.length, InetAddress.getByName("localhost"), 2207);
        client.send(dqReq);
        client.close();
    }
}
