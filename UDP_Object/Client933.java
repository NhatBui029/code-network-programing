/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_Object;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
Mã câu hỏi: 933] Một chương trình (tạm gọi là server) được triển khai tại địa chỉ 203.162.10.109, sử dụng giao thực UDP tại cổng 2209, 
yêu cầu xây dựng chương trình (tạm gọi là client) thực hiện Giao tiếp với server tại cổng 2209 theo kịch bản
Trong đó, đối tượng trao đổi là thể hiện của lớp Student được mô tả như sau:
- Tên đầy đủ lớp: UDP.Student933
- Các thuộc tính: String id, String code, String name, String email
- Hàm khởi tạo
+ public Student (String id, String code, String name, String email)
+ public Student (String code)
Trường dữ liệu: private static final long serialVersionUID = 20161107
Thực hiện
a. Gửi thông điệp là một đối tượng thể hiện của lớp Student với thông tin được thiết lập là code với giá trị tương ứng là mã sinh viên
b. Nhận 1 đối tượng là thể hiện của lớp Student từ server với các thông tin được thiết lập gồm id và name
C. Thực hiện chuẩn hoá tên theo nguyên tắc: Chữ cái đầu tiên in hoa, các chữ cái còn lại in thường và cập nhật lại trường name
Tạp email ptit.edu.vn từ tên người dùng bằng cách lấy tên và chữ cái bắt đầu của họ và tên đệm. 
Ví dụ: nguyen van tuan nam --> namnvt@ptit.edu.vn. Thực hiện gán cho trường email của đối tượng nhận được
Gửi thông điệp chứa đối tượng xử lý ở bước c lên Server 
d. Đóng socket và kết thúc
 */
public class Client933 {
    public static void main(String[] args) {
        try{
            DatagramSocket client = new DatagramSocket();
            
            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
            ObjectOutputStream oos1 = new ObjectOutputStream(baos1);
            oos1.writeObject(new Student933("B20DCCN029"));
            byte[] sendRequestData = baos1.toByteArray();
            DatagramPacket sendRequestPacket = new DatagramPacket(sendRequestData, sendRequestData.length, InetAddress.getByName("127.0.0.1"), 2209);
            client.send(sendRequestPacket);
            
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            client.receive(receivePacket);
            ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Student933 student = (Student933) ois.readObject();
            System.out.println("Nhan duoc Student: "+ student);
            String[] nameArray = student.getName().trim().split("\\s+");
            String nameResult = nameArray[nameArray.length-1].toLowerCase();
            for(int i=0; i<nameArray.length - 1; i++){
                nameResult += nameArray[i].substring(0,1).toLowerCase();
            }
            nameResult += "@ptit.edu.vn";
            student.setEmail(nameResult);
            
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            ObjectOutputStream oos2 = new ObjectOutputStream(baos2);
            oos2.writeObject(student);
            byte[] resultRequestData = baos2.toByteArray();
            DatagramPacket resultRequestPacket = new DatagramPacket(resultRequestData, resultRequestData.length, receivePacket.getAddress(), receivePacket.getPort());
            client.send(resultRequestPacket);
            System.out.println("Da gui object student: "+ student);
            
            client.close();
            
        }catch(Exception e){
            System.out.println("Loi: "+e.toString());
        }
    }
}
