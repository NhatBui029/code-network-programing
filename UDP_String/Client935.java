/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_String;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.LinkedHashSet;


/*
Mà câu hỏi: 935] [Loại bỏ ký tự đặc biệt và ký tự trùng giữ nguyên thử tự xuất hiện]
Viết chương trình client với yêu cầu kết nói Server qua giao thức UDP tại cổng 2208 theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng "; studentCode;qCode". Ví dụ: "3815DCCN001;935" 
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId; strInput"
requestId là chuỗi ngẫu nhiên duy nhất strInput là chuỗi thông điệp cần xử lý
c. Thực hiện loại bỏ ký tự đặc biệt, số và ký tự trùng, yêu cầu giữ nguyên thứ tự xuất hiện của các ký tự. Gửi chuổi lên server 
theo định dạng "requestId;stroutput", trong đó chuỗi strOutput là chuỗi đã được xử lý
d. Đóng socket và kết thúc
 */
public class Client935 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            
            byte[] sendByte = "B20DCCN029;925".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendByte, sendByte.length, InetAddress.getByName("192.168.228.204"), 2208);
            socket.send(sendPacket);
            
            byte[] receiveByte = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveByte, receiveByte.length);
            socket.receive(receivePacket);
//            System.out.println("IP server: "+ receivePacket.getAddress());
//            System.out.println("Port server: "+receivePacket.getPort());
            String receiveStr = new String(receivePacket.getData());
            String[] receiveArr = receiveStr.trim().split("\\;");
            String requestID = receiveArr[0].trim();
            String input = receiveArr[1].trim();
            
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            for(char c: input.toCharArray()){
                if(Character.isLetter(c)) set.add(c);
            }
            
            String result = requestID+";";
            for(char c: set) result +=c;
            byte[] resultByte = result.trim().getBytes();
            DatagramPacket resultPacket = new DatagramPacket(resultByte, resultByte.length, InetAddress.getByName("192.168.228.204"), 2208);
            socket.send(resultPacket);
            
            socket.close();
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
    }
}
