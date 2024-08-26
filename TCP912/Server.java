/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP912;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        // nhan tu client
        String maNhan = br.readLine();
        // gui len server chuoi
        String chuoi = "@$dfghjksdflsjflsd237219d@#$";
        bw.write(chuoi);
        bw.newLine();
        bw.flush();
        // nhan kq
        String kq = br.readLine();
        String kq2 = br.readLine();
        System.out.println(kq+ " " +kq2);
        conn.close();
        server.close();
    }
}
