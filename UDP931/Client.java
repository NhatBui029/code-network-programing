/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP931;

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
        String ma = ";B18dccn250;931";
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
        String[] str1 = str.split(";");
        String ID = str1[0];
        String str2 = str1[1];

        String[] s = str2.split(",");
        int max=Integer.parseInt(s[0]);
        int min =Integer.parseInt(s[0]);
        for(int i=1; i<s.length; i++){
            int tmp = Integer.parseInt(s[i]);
            if(tmp > max){
                max = tmp;
            }
            if(tmp<min){
                min = tmp;
            }
        }

        String ans = ID +";"+max+ "," + min;
        byte[] kq = ans.getBytes();
        gui = new DatagramPacket(kq, kq.length, InetAddress.getByName("localhost"), 2207);
        client.send(gui);
        System.out.println("gui kq");
    }
}
