/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Buffered_Reader_Writer2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

 /*
Mã câu hỏi: 916: Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 
(hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình 
client tương tác với server sử dụng các luồng byte (Bufferedwriter/BufferedReader) kịch bản sau:
a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "MaSV;MaCauhoi". Ví dụ: "B15DCCN999;916"
b.  Nhận lần lượt 2 chuỗi từ server
c. Thực hiện loại bỏ các kí tự xuất hiện trong chuỗi thứ nhất mà ko xuất hiện trong chuỗi thứ 2 ,
sắp xếp theo thứ tự giảm dần kí tự
và gửi lên server 
d.Đóng kết nối và kết thúc chương trình.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("192.168.228.204",2208);
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            
            bw.write("B20DCCN029;916");
            bw.newLine();
            bw.flush();
            
            String str1 = br.readLine();
            String str2 = br.readLine();
            System.out.println(str1+":"+str2);
            
            StringBuilder result = new StringBuilder();
            for(char c: str1.toCharArray()){
                if(str2.indexOf(c)== -1){
                    result.append(c);
                }
            }
            char[] arr = result.toString().toCharArray();
            Arrays.sort(arr);
            String kq = new StringBuilder(new String(arr)).reverse().toString();
            bw.write(kq);
            bw.newLine();
            bw.flush();
            System.out.println("Done: "+ kq);
            
        } catch (Exception e) {
        }
    }
}
