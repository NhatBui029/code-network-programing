/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Mã câu hỏi: 916: Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 
(hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình 
client tương tác với server sử dụng các luồng byte (Bufferedwriter/BufferedReader) kịch bản sau:
a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "MaSV;MaCauhoi". Ví dụ: "B15DCCN999;916"
b.  Nhận lần lượt 2 chuỗi từ server
c. Thực hiện loại bỏ các kí tự xuất hiện trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ 2 
và gửi lên server 
d.Đóng kết nối và kết thúc chương trình.
 */

package TCP_Buffered_Reader_Writer2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author buitu
 */
public class Server916 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2208);
            System.out.println("Khoi tao server socket thanh cong!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

                String request = reader.readLine();
                System.out.println("Received request from client: " + request);

                writer.write("euabcef");
                writer.newLine();
                writer.flush();
                
                writer.write("abc");
                writer.newLine();
                writer.flush();

                // c. Nhận và in thông tin về ký tự xuất hiện nhiều lần từ client
                String countString = reader.readLine();
                System.out.println("Received character count from client: " + countString);
                
                socket.close();
            }
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
    }
}
