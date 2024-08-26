/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_String;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
Mã câu hỏi: 934] Mật mã caesar, còn gọi là mật mã dịch chuyển, để giải quyết mã thì mỗi ký tự nhận được 
sẽ được thay thế bằng một ký tự cách nó một đoạn s. Ví dụ: với s = 3 thì ký tự "A" sẽ được thay thế bằng "D"
Viết chương trình client thực hiện giao tiếp với server qua giao thức UDP, cổng 1107 theo kịch bản sau:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". 
Ví dụ ";B15DCCN001;934"
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestID;strEncode;s"
requestID là chuỗi ngẫu nhiên duy nhất strEncode là chuỗi thông điệp bị mã hoá s là số nguyên độ dịch của mã
c.Thực hiện giải mã tìm thông điệp ban đầu và gửi lên server theo định dạng "requestID;strDecode" 
d. Đóng socket và kết thúc

Sử dụng Server935
 */
public class Client934 {
    public static void main(String[] args) {
        try{
            DatagramSocket client = new DatagramSocket();
            byte[] requestData = ";B20DCCN029;934".getBytes();
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, InetAddress.getByName("localhost"),2208);
            client.send(requestPacket);
            
            byte[] responeData = new byte[1024];
            DatagramPacket responePacket = new DatagramPacket(responeData, responeData.length);
            client.receive(responePacket);
            String responeStr = new String(responePacket.getData()).trim();
            System.out.println("Nhan duoc: "+ responeStr);
            
            String[] arrayRespone = responeStr.split("\\;");
            
            String requestId = arrayRespone[0].trim();
            String data = arrayRespone[1].trim();
            System.out.println("Data: "+data);
            
            String result = "";
            for(char c: data.toCharArray()){
                result += (char)(((int)c)-3);
            }
            
            
            byte[] resultData = (requestId+";"+ result.trim()).getBytes();
            DatagramPacket resultPacket = new DatagramPacket(resultData, resultData.length, responePacket.getAddress(), responePacket.getPort());
            client.send(resultPacket);
            System.out.println("Donee: "+ result);
            
            client.close();
        }catch(Exception e){
            System.out.println("Loi: "+e.toString());
        }
    }
}
