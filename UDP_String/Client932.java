/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_String;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
Giao tiếp với server tại cổng 2288, theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN091;932* 
b. Nhận thông điệp từ server theo định dạng "requestId; data"
requestId là một chuỗi ngẫu nhiên duy nhất
data là chuỗi dữ liệu cần xử lý
c. Xử lý chuẩn hóa chuỗi đã nhận thành theo nguyên tắc
- Ký tự đầu tiên của từng từ trong chuỗi là in hoa
- Các ký tự còn lại của chuỗi là in thường
và thực hiện gửi thông điệp lên server theo định dạng “requestId;data” 
d. Đóng socket và kết thúc

Sử dụng Server935
 */
public class Client932 {
    public static void main(String[] args) {
        try{
            DatagramSocket client = new DatagramSocket();
            byte[] requestData = ";B20DCCN029;932".getBytes();
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, InetAddress.getByName("localhost"),2208);
            client.send(requestPacket);
            
            byte[] responeData = new byte[1024];
            DatagramPacket responePacket = new DatagramPacket(responeData, responeData.length);
            client.receive(responePacket);
            String responeStr = new String(responePacket.getData()).trim();
            System.out.println("Nhan duoc: "+ responeStr);
            
            String[] arrayRespone = responeStr.split("\\;");
            
            String requestId = arrayRespone[0].trim();
            String data = arrayRespone[1].trim().replaceAll("\\s+", " ");
            System.out.println("RequetsId: "+ requestId);
            System.out.println("Data: "+ data);
            
            String result = "";
            for(String str: data.split("\\s+")){
                result += str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase()+" ";
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
