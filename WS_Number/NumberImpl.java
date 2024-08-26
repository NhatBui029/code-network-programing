package WS_Number;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.jws.WebService;

@WebService(endpointInterface = "WS_Number.Numbers")
public class NumberImpl implements Numbers {
    @Override
    public String getNumber() {
        // Thực hiện xử lý và trả về kết quả
        // ... (Thực hiện phần logic tạo chuỗi id và số nguyên từ input)
        return "50000;7602,9136,1090,34319,7830,6179,10584,20166,28199,30250,32179,22544,3222,10320,30590,19279";
    }

    @Override
    public void greatestNumber(String id, String maxNumber) {
        // Thực hiện xử lý và trả về kết quả
        // ... (Thực hiện phần logic tìm số lớn nhất và trả về kết quả)
        System.out.println(id+";"+maxNumber);
    }
}

