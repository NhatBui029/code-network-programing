/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_In_OutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author buitu
 */
public class BinaryServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Khoi tao server socket thanh cong!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Welcome user: " + socket.getPort());
//                BinaryThread service = new BinaryThread(socket);
//                service.start();
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                while (true) {
                    byte[] inputByte = new byte[1024];
                    int n = is.read(inputByte);
                    String inputStr = new String(inputByte, 0, n);
                    if (inputStr.equals("exit")) {
                        break;
                    }
                    System.out.println("Nhan duoc: " + inputStr);
                    os.write(("1402;").getBytes());
                }
                socket.close();
                System.out.println("Da ket thuc " + socket.getInetAddress());

            }
        } catch (Exception e) {
            System.out.println("Lỗi:" + e.toString());
        }
    }
}
