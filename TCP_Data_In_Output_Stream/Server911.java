/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /* 
[Mã câu hỏi: 911] Một chương trình máy chủ cho phép kết nối qua TCP tại cổng 897 (hỗ trợ thời gian liên lạc tối đa ch 5s). 
Yêu cầu là xây dựng chương trình client tương tác với server trên bằng các byte stream (DataInputStream/DataOutputStream) 
đồỉ thông tin theo trình tự sau:
a. Gửi một chuỗi chứa mã sinh viên và mã câu hỏi ở định dạng "studentCode, qCode". Ví dụ: "B15DCCN999;911"
b. Nhận hai số nguyên a và b tương ứng từ máy chủ
c. Tính ước chung lớn nhất, bội chung nhỏ nhất, tổng, tích. Gửi từng giá trị số nguyên theo thứ tự trên đến máy chủ. 
d. ống kết nối và kết thúc chương trình.
 */
package TCP_Data_In_Output_Stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author buitu
 */
public class Server911 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(897);
            System.out.println("Khoi tao server socket thanh cong port 897!");
            while (true) {
                Socket socket = server.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                
                String user = dis.readUTF();
                System.out.println("Nhan duoc request tu user: "+ user);
                
                dos.writeInt(8);
                dos.writeInt(18);
                
                int gcd = dis.readInt();
                long lcm = dis.readLong();
                int sum = dis.readInt();
                long multi = dis.readLong();
                
                
                System.out.print("ket qua: ");
                System.out.print(Integer.toString(gcd)+" ");
                System.out.print(Long.toString(lcm)+" ");
                System.out.print(Integer.toString(sum)+" ");
                System.out.println(Long.toString(multi)+" ");
                
                socket.close();
            }
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
    }
}
