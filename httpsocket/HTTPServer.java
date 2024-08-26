/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi.httpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Web server started on port 8080....");

        while (true) {
            try (Socket conn = server.accept();
                 BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                 OutputStream os = conn.getOutputStream()) {

                String line = br.readLine();
                while (line != null && !line.isEmpty()) {
                    System.out.println(line);
                    line = br.readLine();
                }

                System.out.println("......end print request.....");

                String response = "Hello, World!";
                String responseHeader = "HTTP/1.1 200 OK\r\nContent-Length: " + response.length() + "\r\n\r\n";

                os.write(responseHeader.getBytes());
                os.write(response.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
