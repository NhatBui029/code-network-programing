/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP931;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;

/**
 *
 * @author AD
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(2207);
        while (true) {            
            // nhan tu client
            byte[] buf = new byte[1024];
            DatagramPacket nhan = new DatagramPacket(buf, buf.length);
            server.receive(nhan);
            System.out.println("nhan thanh cong");
            // gui di
            String s = "requestId;";
            Random g = new Random();
            for(int i = 1; i <=50; i++){
                int c = g.nextInt(50); 
                s += (String.valueOf(c)) + ",";
            }
            s=s.substring(0, s.length()-1);
            System.out.println(s);
            DatagramPacket gui = new DatagramPacket(s.getBytes(), s.length(), nhan.getAddress(), nhan.getPort());
            server.send(gui);
            System.out.println("gui chuoi len client thanh cong");
            // nhan kq
            byte[] buf2 = new byte[1024];
            nhan = new DatagramPacket(buf2, buf2.length);
            server.receive(nhan);
            System.out.println("nhan kq thanh cong: " + new String(nhan.getData()).trim());
        }
    }
}
