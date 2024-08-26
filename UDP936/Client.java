/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP936;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/**
 *
 * @author AD
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        // gui ma
        String ma = "B18dccn250;936";
        DatagramPacket gui =new DatagramPacket(ma.getBytes(), ma.length(), InetAddress.getByName("localhost"), 2207);
        client.send(gui);
        // nhan chuoi tu sever
        byte[] buf = new byte[1024];
        DatagramPacket nhan = new DatagramPacket(buf, buf.length);
        client.receive(nhan);
        //xu ly
        String chuoi = new String(nhan.getData()).trim();
        
//        System.out.println(chuoi);
//        String dataString1 = chuoi.trim().split(";")[1];
//        String dataString2 = chuoi.trim().split(";")[2];  
//        StringTokenizer token = new StringTokenizer(dataString1, dataString2);
//        
//        String kq = "";
//        while(token.hasMoreTokens()){
//            kq += token.nextToken();
//        }
//        
//        String kqSendSer = "requestID;" + kq;
        String[] s = chuoi.split(";");
        String ans = s[0]+";";
        String s1 = s[1];
        String s2 = s[2];
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            String s3 = c +"";
            if(!s2.contains(s3)){
                ans+=s3;
            }
        }
        System.out.println(ans);
        //gui len server
//        System.out.println();
        gui =new DatagramPacket(ans.getBytes(), ans.length(), InetAddress.getByName("localhost"), 2207);
        client.send(gui);
    }
}
