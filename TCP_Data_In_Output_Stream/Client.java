/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Data_In_Output_Stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
[Mã câu hỏi: 911] Một chương trình máy chủ cho phép kết nối qua TCP tại cổng 897 (hỗ trợ thời gian liên lạc tối đa ch 5s). 
Yêu cầu là xây dựng chương trình client tương tác với server trên bằng các byte stream (DataInputStream/DataOutputStream) 
đồỉ thông tin theo trình tự sau:
a. Gửi một chuỗi chứa mã sinh viên và mã câu hỏi ở định dạng "studentCode, qCode". Ví dụ: "B15DCCN999;911"
b. Nhận hai số nguyên a và b tương ứng từ máy chủ
c. Tính ước chung lớn nhất, bội chung nhỏ nhất, tổng, tích. Gửi từng giá trị số nguyên theo thứ tự trên đến máy chủ. 
d. ống kết nối và kết thúc chương trình.
 */
public class Client {
    
    public static int gcd(int a,int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static void main(String[] args) {
        try {
            Socket client = new Socket("192.168.228.204",897);
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            
            dos.writeUTF("B20DCCN029;911");
            
            
            int n = dis.readInt();
            int m = dis.readInt();
            int gcd = gcd(m,n);
            long lcm = m*n/gcd;
            
            dos.writeInt(gcd);
            dos.writeLong(lcm);
            dos.writeInt(m+n);
            dos.writeLong(m*n);
            
            System.out.println("Done: ");
            client.close();
        } catch (Exception e) {
        }
    }
}
