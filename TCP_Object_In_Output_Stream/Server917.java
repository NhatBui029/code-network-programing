package TCP_Object_In_Output_Stream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server917 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2299);
            System.out.println("Server khoi tao...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client: "+socket.getInetAddress());

                // Tạo luồng đầu vào và đầu ra cho socket
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                // Nhận chuỗi mã sinh viên và mã câu hỏi từ client
                String requestString = (String) ois.readObject();
                System.out.println("user: " + requestString);


                // Tạo đối tượng Product917 (giả sử bạn đã có logic để lấy thông tin sản phẩm từ cơ sở dữ liệu)
                Product917 product = new Product917(1, "P001", "T520 ThinkPad Lenovo Laptop", 9981);
//                Customer918 cus = new Customer918(1, "U312", "bui tuan   NHAT  ", "02/14/2002", "nhatbt");

                // Gửi đối tượng Product917 về client
                oos.writeObject(product);

                // Nhận đối tượng Product917 đã được sửa đổi từ client
                Product917 modifiedProduct = (Product917) ois.readObject();
                System.out.println("objetc edited: " + modifiedProduct);

                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
