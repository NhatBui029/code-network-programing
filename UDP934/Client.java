/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP934;

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
        // gui ma
        String ma = "B18dccn250;934";
        DatagramPacket gui =new DatagramPacket(ma.getBytes(), ma.length(), InetAddress.getByName("localhost"), 2207);
        client.send(gui);
        // nhan chuoi tu sever
        byte[] buf = new byte[1024];
        DatagramPacket nhan = new DatagramPacket(buf, buf.length);
        client.receive(nhan);
        //xu ly
        String chuoi = new String(nhan.getData()).trim();
        System.out.println(chuoi);
        String[] s = chuoi.split(";");
        String ans = s[0]+";";
        String s1 = s[1];
        int s2 = Integer.parseInt(s[2]);
        System.out.println(ans+s1+s2);
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            c += s2;
            ans+=c;
        }
//        ans+=";"+s1;
        System.out.println(ans);
        //gui len server
        gui =new DatagramPacket(ans.getBytes(), ans.length(), InetAddress.getByName("localhost"), 2207);
        client.send(gui);
    }
}
