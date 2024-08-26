/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP802;

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
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        // gui
        String ma = ";B18dccn250;802";
        DatagramPacket gui = new DatagramPacket(ma.getBytes(), ma.length(), InetAddress.getByName("localhost"), 2207);
        client.send(gui);
        // nhan tu server
        byte buf[] = new byte[1024];
        DatagramPacket nhan = new DatagramPacket(buf, buf.length);
        client.receive(nhan);
        // xu ly
        String s = new String(nhan.getData());
        String[] s1 = s.split(";");
        int n = Integer.parseInt(s1[1].trim());
        StringBuilder xau = new StringBuilder(s1[0] + ";");
        boolean t = true;
        for(int i = 1; i <= n; i++){
            if(!s1[2].contains(i+"")){
                xau.append(i+",");
                t=true;
            }
        }
        String kq = xau.toString();
        if(t)   kq = kq.substring(0, kq.length()-1);
        System.out.println(kq);
        // gui kq
        gui = new DatagramPacket(kq.getBytes(), kq.length(),InetAddress.getByName("localhost"),2207);
        client.send(gui);
        client.close();
    }
}
