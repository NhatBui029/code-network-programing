/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP801;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author AD
 */
public class Server {
    public static void main(String args[]) throws IOException {
        // TODO code application logic here
        DatagramSocket server = new DatagramSocket(2207);
        while (true) {       
            //nhan du lieu tu client gui len
            byte[] buf = new byte[1024];
            DatagramPacket dqReq = new DatagramPacket(buf, buf.length);
            server.receive(dqReq);
            byte[] data = dqReq.getData();
            System.out.println("Da nhan: "+new String(data).trim());
            //gui thong diep ve cho client
            String str = "B18DCCN250; 10; 1,2,3,4,5";
            DatagramPacket dqRes = new DatagramPacket(str.getBytes(), str.length(), dqReq.getAddress(), dqReq.getPort());
            server.send(dqRes);
            
            //nhan KQ tu client gui len
            byte[] buf2 = new byte[1024];
            dqReq = new DatagramPacket(buf2, buf2.length);
            server.receive(dqReq);
            byte[] data2 = dqReq.getData();
            System.out.println("Da nhan2: "+new String(data2).trim());
        }
        
    }
}
