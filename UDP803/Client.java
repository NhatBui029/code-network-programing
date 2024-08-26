/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP803;

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
        // gui len sv
        String ma = ";B18dccn250;803";
        DatagramPacket gui = new DatagramPacket(ma.getBytes(), ma.length(),InetAddress.getByName("localhost"), 2207);
        client.send(gui);
        System.out.println("guithanhcong");
        // nhan tu sv
        byte[] buf = new byte[1024];
        DatagramPacket nhan = new DatagramPacket(buf, buf.length);
        client.receive(nhan);
        //xuly
        String s = new String(nhan.getData());
       String[] s1 = s.split(";");
        StringBuilder xau = new StringBuilder(s1[0]+";");
        int dem[] = new int[256];
        s1[1]=s1[1].trim();
        int len = s1[1].length();
//        System.out.println(len);
        for(int i = 0; i < len; i++){
            dem[s1[1].charAt(i)]++;
        }
        int max = 0;
        char maxvalue = 'C';
        for(int i =0 ; i < len; i++){
            if(dem[s1[1].charAt(i)] > max){
                max = dem[s1[1].charAt(i)];
                maxvalue = s1[1].charAt(i);
            }
        }
        boolean t = true;
        for(int i = 0; i < len; i++){
//            System.out.println(len);
            char c = s1[1].charAt(i);
            if(dem[s1[1].charAt(i)] == max && c == maxvalue){
                if(t)   xau.append(s1[1].charAt(i)+ ":");
                t = false;
                xau.append(i+",");
            }
        }
        String kq = xau.toString();
        System.out.println(kq);
        // gui kq
        gui = new DatagramPacket(kq.getBytes(), kq.length(),InetAddress.getByName("localhost"), 2207);
        client.send(gui);
        client.close();
    }
}
