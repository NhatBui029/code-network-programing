/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP721;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author AD
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        Socket conn = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        String maNhan = br.readLine();
        String chuoi = "drtfyghjkk dsdf";
        bw.write(chuoi);
        bw.newLine();
        bw.flush();
        String kq = br.readLine();
        System.out.println(kq);
        conn.close();
        server.close();
    }
}
