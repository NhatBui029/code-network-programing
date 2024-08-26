/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Mã câu hỏi: 721: Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 808 
(hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình 
client tương tác với server sử dụng các luồng byte (Bufferedwriter/BufferedReader) kịch bản sau:
a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "MaSV;MaCauhoi". Ví dụ: "B15DCCN999;721"
b.  Nhận một chuỗi ngẫu nhiên từ server ví dụ: dgU0o ch2k221ds0o
c. Liệt kê các ký tự (là chữ hoặc số) xuất hiện nhiều hơn một lần trong chuỗi và số lần xuất hiện 
của chúng và gửi lên server Ví dụ: d:2,0:2,o:2,2:3
d.Đóng kết nối và kết thúc chương trình.
 */

package TCP_Buffered_Reader_Writer1;

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
public class Server721 {

    private static String generateRandomString() {
        int length = 10;
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            randomString.append(c);
        }
        return randomString.toString();
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(808);
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

                String randomString = generateRandomString();
                writer.write("uhew cdwe wedwq ưe");
                writer.newLine();
                writer.flush();
                System.out.println("Sent random string to client: " + randomString);

                // c. Nhận và in thông tin về ký tự xuất hiện nhiều lần từ client
                String countString = reader.readLine();
                System.out.println("Received character count from client: " + countString);

            }
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
    }
}
