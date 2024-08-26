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
Mã câu hỏi: 917]Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể: 
Tên sản phẩm bị đổi ngược từ đầu tiến và từ cuối cùng, ví dụ: "lenovo thinkpad T520” bị chuyển 
thành “T520 thinkpad lenovo”, Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899 
Viết chương trình client kết nối với server bằng giao thức UDP tại cổng 2299, tiếp nhận thông tin về sản phẩm và 
thực hiện sửa các thông tin sai của sản phẩm. 
Trong đó: Đối tượng trao đổi là thể hiện của lớp Product917 được mô tả như sau 
- Tên đầy đủ  của lớp: TCP.Product917 
- Các thuộc tính: id String, code String, name String, quantity int 
- Hàm khởi tạo đầy đủ các thuộc tính được liệt kê ở trên -
Trường dữ liệu: private static final long serialVersionUID = 937; 
Yêu cầu kết nối với server theo kịch bản 
a. Gửi thông điệp là 1 đối tượng của lớp Product937 với thông tin được thiết lập là code là giá trị của mã sinh viên
b. Nhận một đối tượng là thể hiện của lớp Product937 từ server vs thông tin được thiết lập thêm là id, name, quantity
c. Thực hiện sửa các thông tin sai của sản phẩm (tên và số lượng). Gửi đối tượng vừa được sửa đổi lên server
d. Đông socket và kết thúc,
 */
public class Client937 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            
            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
            ObjectOutputStream oos1 = new ObjectOutputStream(baos1);
            oos1.writeObject(new Product937("", "B20DCCN029", "", 0));
            byte[] sendByte = baos1.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendByte, sendByte.length, InetAddress.getByName("192.168.228.204"),2209);
            socket.send(sendPacket);
            
            byte[] receiveByte = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveByte, receiveByte.length);
            socket.receive(receivePacket);
            ByteArrayInputStream bais1 = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream ois1 = new ObjectInputStream(bais1);
            Product937 product = (Product937) ois1.readObject();
            String[] nameArr = product.getName().trim().split("\\s+");
            String name = nameArr[nameArr.length-1]+" ";
            for(int i=1; i<nameArr.length-1; i++){
                name+=nameArr[i]+" ";
            }
            name+=nameArr[0];
            product.setName(name);
            
            String quantity = new StringBuilder(Integer.toString(product.getQuantity())).reverse().toString().trim();
            product.setQuantity(Integer.parseInt(quantity));
            
            
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            ObjectOutputStream oos2 = new ObjectOutputStream(baos2);
            oos2.writeObject(product);
            byte[] resultByte = baos2.toByteArray();
            DatagramPacket resultPacket = new DatagramPacket(resultByte, resultByte.length, InetAddress.getByName("192.168.228.204"),2209);
            socket.send(resultPacket);
            
            System.out.println("Done: "+ product);
            socket.close();
        } catch (Exception e) {
        }
    }
}
