/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_In_OutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author buitu
 */
public class BinaryThread extends Thread {

    Socket socket;

    public BinaryThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
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
                os.write(("Da nhan duoc: " + inputStr).getBytes());
            }
            socket.close();
            System.out.println("Da ket thuc " + socket.getInetAddress());
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
    }
}
