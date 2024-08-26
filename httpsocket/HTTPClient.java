/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi.httpsocket;
import java.io.*;
import java.net.*;
/**
 *
 * @author buitu
 */
public class HTTPClient {
    public static void main(String[] args) throws Exception{
        Socket client = new Socket("www.google.com",80);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String request = "";
        bw.write(request);
        bw.newLine();
        bw.flush();
        
        InputStream is = client.getInputStream();
        byte[] data = new byte[4096];
        is.read(data);
        
        is.close();
        bw.close();
        client.close();
    }
}
