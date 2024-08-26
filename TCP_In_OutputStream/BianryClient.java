/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_In_OutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author buitu
 */
public class BianryClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",9000);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("Nhap: ");
                String input = sc.nextLine();
                
                byte[] inputByte = input.getBytes();
                os.write(inputByte);
                
                if(input.equals("exit")) break;              
                
                byte[] resultByte = new byte[1024];
                int n = is.read(resultByte);
                String resultStr = new String(resultByte,0,n);
                System.out.println("Log: "+resultStr);
            }
            socket.close();
        }catch(Exception e){
            System.out.println("Lỗi:"+ e.toString());
        }
    }
}
