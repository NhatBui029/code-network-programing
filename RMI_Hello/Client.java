 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI_Hello;

import java.rmi.Naming;

/**
 *
 * @author buitu
 */
public class Client {
    public static void main(String[] args) throws Exception{
        try{
            HelloInterface hello = (HelloInterface) Naming.lookup("rmi://192.168.228.204:1099/hello");
            System.out.println("Ket qua: "+hello.hello("Bui Tuan Nhat"));
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
    }
}
