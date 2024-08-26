/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI_Hello;

import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author buitu
 */
public class Server {
    public static void main(String[] args) throws Exception{
        try{
            LocateRegistry.createRegistry(1099);
            HelloImpl hello = new HelloImpl();
            Naming.rebind("rmi://localhost:1099/hello", hello);
            System.out.println("Register: hello");
        }catch(Exception e){
            System.out.println("Error: "+ e.toString());
        }
    }
}
