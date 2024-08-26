/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_In_Output_Stream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * Mã câu hỏi: 917]Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể: 
 * Tên sản phẩm bị đổi ngược từ đầu tiến và từ cuối cùng, ví dụ: "lenovo thinkpad T520” bị chuyển 
 * thành “T520 thinkpad lenovo”, Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899 
 * Viết chương trình client kết nối với server bằng giao thức TCP tại cổng 2299, sử dụng luồng đối tượng 
 * (ObjectInputStream / ObjectOutputStream) tiếp nhận thông tin về sản phẩm và thực hiện sửa các thông tin sai của sản phẩm. 
 * Trong đó: Đối tượng trao đổi là thể hiện của lớp Product917 được mô tả như sau - Tên đầy đủ
 * của lớp: TCP.Product917 - Các thuộc tính: id int, code String, name String,
 * quantity int - Hàm khởi tạo đầy đủ các thuộc tính được liệt kê ở trên -
 * Trường dữ liệu: private static final long serialVersionUID = 917; Yêu cầu kết
 * nối với server theo kịch bản 
 * a. Gửi chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;gCode". Ví dụ: "B15DCCM999;917" 
 * b. Nhận một đối tượng là thể hiện của lớp Product917 từ server 
 * c. Thực hiện sửa các thông tin sai của sản phẩm (tên và số lượng). Gửi đối tượng vừa được sửa đổi lên server
 * d. Đông socket và kết thúc,
 */

public class Client917 {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.228.204", 1107);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            // Gửi chuỗi mã sinh viên và mã câu hỏi
            String studentCode = "B20DCCN029";
            int questionCode = 917;
            String requestString = studentCode + ";" + questionCode;
            oos.writeObject(requestString);

//            Customer918 cus = (Customer918) ois.readObject();
//            System.out.println(cus.getName());

            // Nhận đối tượng Product917 từ server
            Product917 product = (Product917) ois.readObject();
            // Hiển thị thông tin sản phẩm trước khi sửa đổi
            System.out.println("info product:");
            System.out.println("ID: " + product.getId());
            System.out.println("Code: " + product.getCode());
            System.out.println("Name: " + product.getName());
            System.out.println("Quantity: " + product.getQuantity());

            // Sửa thông tin sản phẩm
            // Ví dụ: Đảo ngược tên sản phẩm và đảo ngược giá trị số lượng
            String[] nameParts = product.getName().split(" ");
            String reverseName = "";
            for(int i = nameParts.length-1;i>=0;i--){
                reverseName += nameParts[i]+" ";
            }
            product.setName(reverseName.trim());
            
            String reverseQuantity = new StringBuilder(Integer.toString(product.getQuantity())).reverse().toString().trim();
            product.setQuantity(Integer.parseInt(reverseQuantity));

            // Gửi đối tượng đã được sửa đổi về server
            oos.writeObject(product);

            // Đóng kết nối
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
