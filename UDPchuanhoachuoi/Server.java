/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPchuanhoachuoi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author AD
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(1107);
        while(true){
            byte[] buf = new byte[1024];
            DatagramPacket dpReq = new DatagramPacket(buf, buf.length);
            server.receive(dpReq);
            byte[] data = dpReq.getData();
            System.out.println(new String(data).trim());
            
            String s = "requestID;abc  ddd";
            DatagramPacket dpRes = new DatagramPacket(s.getBytes(), s.length()
                            , dpReq.getAddress(), dpReq.getPort());
                        server.send(dpRes);
            server.send(dpRes);
            
            byte[] recv = new byte[1024];
            DatagramPacket recvCl = new DatagramPacket(recv, recv.length);
            server.receive(recvCl);
            byte[] dataKQ = recvCl.getData();
            System.out.println(new String(dataKQ).trim());
            
            
        }
    }
}
