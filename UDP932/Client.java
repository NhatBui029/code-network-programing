/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP932;

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
        // gui den server
        String ma = ";B18dccn250;932";
        DatagramPacket gui = new DatagramPacket(ma.getBytes(), ma.length(), InetAddress.getByName("localhost"), 2207);
        client.send(gui);
        System.out.println("gui thanh cong");
        // nhan
        byte[] buf = new byte[1024];
        DatagramPacket nhan = new DatagramPacket(buf, buf.length);
        client.receive(nhan);
        System.out.println("nhan chuoi tu server thanh cong");
        // xuly
        String str = new String(nhan.getData()).trim();
//        System.out.println(str);
        String[] s = str.split(";");
        String s1 = s[0].trim();
        String s2 = s[1].trim();
        String arr[] = s2.split(" ");
        String ans = s1+";";
        for(int i = 0; i < arr.length; i++){
            ans+= arr[i].substring(0,1).toUpperCase()+arr[i].substring(1).toLowerCase()+" ";
//            System.out.println(ans);
        }
        ans = ans.trim();
        System.out.println(ans);
        gui = new DatagramPacket(ans.getBytes(), ans.length(), InetAddress.getByName("localhost"), 2207);
        client.send(gui);
        System.out.println("gui kq");
    }
}
    