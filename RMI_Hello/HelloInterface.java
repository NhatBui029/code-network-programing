/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI_Hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author buitu
 */
public interface HelloInterface extends Remote{
    public String hello(String name) throws RemoteException;
}
