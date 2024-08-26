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
            // gui ddi client
            String chuoi = "B18dccn250;10;1,1,2,3,4";
            DatagramPacket gui = new DatagramPacket(chuoi.getBytes(),chuoi.length(), nhan.getAddress(), nhan.getPort());
            server.send(gui);
            // nhan kq
            byte[] buf2 = new byte[1024];
            nhan = new DatagramPacket(buf2, buf2.length);
            server.receive(nhan);
            System.out.println(new String(nhan.getData()));
//            server.close();
        }
        
    }
}
