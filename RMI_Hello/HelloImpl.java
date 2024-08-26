/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI_Hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author buitu
 */
public class HelloImpl extends UnicastRemoteObject implements HelloInterface{
    
    public HelloImpl() throws RemoteException{
        super();
    }

    @Override
    public String hello(String name) throws RemoteException {
        return "Xin chao: "+name;
    }
    
}
