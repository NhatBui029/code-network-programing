/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP701;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author AD
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        
        System.out.println("Server is now already");
        Socket conn = server.accept();
        InputStream input = new DataInputStream(conn.getInputStream());
        OutputStream output = new DataOutputStream(conn.getOutputStream());
//        String maNhan = input.readUTF();
        // nhan ma
        byte[] receivedData = new byte[65536];
        input.read(receivedData);
        String res = new String(receivedData).trim();
        //gui chuoi
        String chuoi = "1,3,9,19,33,20";
        output.write(chuoi.getBytes());
        output.flush();
        // nhan kq
        byte[] receivedData2 = new byte[65536];
        input.read(receivedData2);
        String res2 = new String(receivedData2).trim();
        conn.close();
        server.close();
    }
}
