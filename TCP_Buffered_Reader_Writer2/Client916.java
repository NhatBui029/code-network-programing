/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
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
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.LinkedHashSet;

/**
 *
 * @author buitu
 */
public class Client916 {
    
    public static String editStr(String str1, String str2) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : str1.toCharArray()) {
            if (Character.isLetter(c)) {
                if (str2.indexOf(c) == -1 ) {
                    set.add(c);
                }
            }
        }
        String result = "";
        for(char c: set) result+=c;
        
        
        return result;
    }
    
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2208);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            bw.write("B20DCCN029;916");
            bw.newLine();
            bw.flush();
            
            String str1 = br.readLine();
            String str2 = br.readLine();            
            System.out.println("Nhan duoc 2 chuoi: " + str1 + " and " + str2);
            
            bw.write(editStr(str1, str2));
            bw.newLine();
            bw.flush();
            System.out.println("donee: " + editStr(str1, str2));
            socket.close();
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
    }
}
