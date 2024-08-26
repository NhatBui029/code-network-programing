/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPchuanhoachuoi;

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
public class Client{
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        String str;
        str = ";studentCode;qCode";
        DatagramPacket dpreq = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 1107); //203.162.10.109
        client.send(dpreq);

        byte[] buf = new byte[1024];
        DatagramPacket dpReq = new DatagramPacket(buf, buf.length);
        client.receive(dpReq);

        String Receive = new String(dpReq.getData()).trim();
        String dataString = Receive.trim().split(";")[1];
        dataString = dataString.replaceAll("\\s+", " ");
        String[] temp = dataString.split(" ");
        dataString = "";
        for (int i = 0; i < temp.length; i++) {
            dataString += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1)
            {
                dataString += " ";
            }
        }

        String kq = "requestID;" + dataString;
        DatagramPacket sendSer = new DatagramPacket(kq.getBytes(), kq.length(), InetAddress.getByName("localhost"), 1107);
        client.send(sendSer);
        
        //System.out.println(kq);
    }
}
