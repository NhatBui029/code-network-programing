/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Data_In_Output_Stream;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author buitu
 */
public class Client911 {
    public static int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
    
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",897);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            dos.writeUTF("B20DCCN029;911");
            
            int a = dis.readInt();
            int b = dis.readInt();
            
            System.out.println("Nhan duoc 2 so nguyen: "+Integer.toString(a)+" and "+ Integer.toString(b));
            
            dos.writeInt((gcd(a,b)));
            dos.writeLong((a*b/gcd(a,b)));
            dos.writeInt(a+b);
            dos.writeLong(a*b);
            
            System.out.println("Doneee !!");
            socket.close();
        }catch(Exception e){
            System.out.println("Loi: "+ e.toString());
        }
    }
}
