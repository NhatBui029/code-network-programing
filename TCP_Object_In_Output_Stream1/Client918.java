/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_In_Output_Stream1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
/*
Mã câu hỏi: 918] Thông tin khách hàng cần thay đổi định dạng lại cho phù hợp với khu vực, cụ thể:
a.Tên khách hàng cần được chuẩn hoá và theo định dạng mới. Ví dụ: nguyen van hai duong. --> DUONG, Nguyen Van Hai
b. Ngày sinh của khách hàng đang ở mm-dd-yyyy, cần được chuyển thành định dạng dd/mm/yyyy. Ví dụ: 10-11-2012 --> 11/10/2012
c. Tài khoản là các chữ cái in thường được sinh tự động từ họ tên khách hàng. Ví dụ: nguyen van hai duong -> nvhduong 
Viết chương trình client kết nối với server bằng giao thức TCP tại cổng 1107, sử dụng luồng đối tượng 
(ObjectInputStream/ ObjectOutputStream) tiếp nhận thông tin về sản phẩm và thực hiện sửa các thông tin sai của sản phẩm. trong đó
a. Đối tượng trao đổi là thể hiện của lớp Customer918 được mô tả như sau
Tên đầy đủ của lớp: TCP.Custumer918
Các thuộc tính: int id, String code, String name, String dayOfBirdth, String userName
Hàm khởi tạo dầy đủ các thuộc tính được liệt kê ở trên 
Trường dữ liệu: private static final long serialVersionUID = 918;
b. Kết nối với server theo kịch bản
- Gửi chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ "B15DCCN999;918"
- Nhận 1 đối tượng là thể hiện của lớp Customer918 từ server với các thông tin đã được thiết lập
- Thực hiện thay đổi định dạng theo các yêu cầu ở trên và gắn vào các thuộc tính tương ứng. 
- Gửi đối tượng vừa được sửa đổi lên server
- Đóng socket và kết thúc
 */

public class Client918 {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.228.204", 1107);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            oos.writeObject("B20DCCN029;918");
            
            Customer918 cus = (Customer918) ois.readObject();
            
            String[] nameArr = cus.getName().trim().split("\\s+");
            String name = nameArr[nameArr.length-1].toUpperCase()+", ";
            String user = "";
            for(int i = 0; i<nameArr.length-1;i++){
                name+= nameArr[i].substring(0,1).toUpperCase()+nameArr[i].substring(1).toLowerCase()+" ";
                user+= nameArr[i].substring(0,1).toLowerCase();
            }
            user+=nameArr[nameArr.length-1].toLowerCase();
            cus.setName(name.trim());
            cus.setUserName(user.trim());
            
            String[] nsArr = cus.getDateOfBirth().trim().split("\\/");
            String ns = nsArr[1]+"/"+nsArr[0]+"/"+nsArr[2];
            cus.setDateOfBirth(ns);
            
            oos.writeObject(cus);
            System.out.println("Done: "+cus);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
