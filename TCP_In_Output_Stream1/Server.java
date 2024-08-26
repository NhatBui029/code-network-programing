/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_In_Output_Stream1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
Mã câu hỏi: 721: Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 808 
(hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình 
client tương tác với server sử dụng các luồng byte (InputStream/OutputStream) kịch bản sau:
a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "MaSV;MaCauhoi". Ví dụ: "B15DCCN999;721"
b.  Nhận một chuỗi ngẫu nhiên từ server ví dụ: dgU0o ch2k221ds0o
c. Liệt kê các ký tự (là chữ hoặc số)  trong chuỗi và số lần xuất hiện 
của chúng và gửi lên server, sắp xếp theo thứ tự số lần xuất hiện giảm dần, Ví dụ: 2:3,d:2,0:2,o:2
d.Đóng kết nối và kết thúc chương trình.
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(808);
            System.out.println("Khoi tao server socket thanh cong!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Welcome user: " + socket.getPort());
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                
                    byte[] inputByte = new byte[1024];
                    int n = is.read(inputByte);
                    String inputStr = new String(inputByte, 0, n);
                    if (inputStr.equals("exit")) {
                        break;
                    }
                    System.out.println("Request: " + inputStr);
                    os.write(("1402;uoce23 d23j -- 2.3dew/aqabc    ,,4.5den aw xmzsja-q23eqd;aawq,xaw2q").getBytes());
                    
                    byte[] resultByte = new byte[1024];
                    int m = is.read(resultByte);
                    String result = new String(resultByte, 0, m);
                    System.out.println("Ket qua: "+ result);
                
                socket.close();
                System.out.println("Da ket thuc " + socket.getInetAddress());

            }
        } catch (Exception e) {
            System.out.println("Lỗi:" + e.toString());
        }
    }
}
