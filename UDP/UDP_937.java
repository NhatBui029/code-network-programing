/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author pc
 */
public class UDP_937 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            Product937 pro = new Product937();
            pro.setCode("B18DCCN411");

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(pro);

            byte[] sendData1 = baos.toByteArray();
            DatagramPacket dp1 = new DatagramPacket(sendData1, sendData1.length, InetAddress.getByName("203.162.10.109"), 2209);
            socket.send(dp1);
            oos.flush();

            byte[] receivedData = new byte[65536];
            DatagramPacket dp2 = new DatagramPacket(receivedData, receivedData.length);
            socket.receive(dp2);
            byte[] data = dp2.getData();
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);

            Product937 product937 = (Product937) ois.readObject();
            System.out.println(product937);
            String name = product937.getName();
            String quan = Integer.toString(product937.getQuantity());

            String[] split = name.split(" ");
            StringBuilder builder1 = new StringBuilder();
            builder1.append(split[split.length - 1]).append(" ");
            for (int i = 1; i < split.length - 1; i++) {
                builder1.append(split[i]);
                builder1.append(" ");
            }
            builder1.append(split[0]);
            product937.setName(builder1.toString());

            StringBuilder builder2 = new StringBuilder();
            for (int i = quan.length() - 1; i >= 0; i--) {
                builder2.append(quan.charAt(i));
            }

            int quantity = Integer.parseInt(builder2.toString());
            product937.setQuantity(quantity);
            System.out.println(product937);
            
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            ObjectOutputStream oos2 = new ObjectOutputStream(baos2);
            oos2.writeObject(product937);
            byte[] sendData2 = baos2.toByteArray();
            DatagramPacket dp3 = new DatagramPacket(sendData2, sendData2.length, InetAddress.getByName("203.162.10.109"), 2209);
            socket.send(dp3);

            socket.close();
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
