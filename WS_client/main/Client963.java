/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ws_product.Product;
import ws_product.ProductImplService;
import ws_product.ProductInterface;

/**
 *
 * @author buitu
 */
public class Client963 {
    public static void main(String[] args) throws Exception {
        try {
            ProductImplService service = new ProductImplService();
            ProductInterface productWS = (ProductInterface) service.getProductImplPort();
            Product product = productWS.getProduct("B20DCCN029");
            System.out.println("Product: "+ product.getName());
            
            DatagramSocket socket = new DatagramSocket();
            byte[] sendByte = (product.getId()+";"+product.getCode()).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendByte, sendByte.length, InetAddress.getByName("localhost"),2208);
            socket.send(sendPacket);
            
            byte[] buf = new byte[1024];
            DatagramPacket bufPacket = new DatagramPacket(buf, buf.length);
            socket.receive(bufPacket);
            String input = new String(bufPacket.getData());
            int discount = 0;
//            for(char c: input.toCharArray()){
//                if(Character.isDigit(c)) discount += Integer.parseInt(String.valueOf(c));
//            }
            for(int i=0;i<input.length();i++){
                if(input.charAt(i)>='0' && input.charAt(i)<='9') discount+=Integer.parseInt(String.valueOf(input.charAt(i)));
            }            
            
            System.out.println("discount: "+discount);
            product.setDiscount(discount);
            productWS.order(product);
        } catch (Exception ex) {
            
        }
        
    }
}
