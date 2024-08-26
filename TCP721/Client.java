/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP721;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author AD
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("Localhost", 1234);
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String ma = "B18dccn250;721";
        bw.write(ma);
        bw.newLine();
        bw.flush();
        String chuoi = br.readLine();
        int dem[] = new int[256];
        int len=chuoi.length();
        for(int i = 0; i < len; i++){
            dem[chuoi.charAt(i)]++;
        }
//        for(int i = 0; i < len; i++){
//            System.out.println(dem[chuoi.charAt(i)]);
//        }
        String kq="";
        for(int i = 0; i < len; i++){
             if(dem[chuoi.charAt(i)] > 1){
                 kq+=chuoi.charAt(i)+":"+dem[chuoi.charAt(i)]+",";
                 dem[chuoi.charAt(i)] = 0;
             }
        }
        bw.write(kq);
        bw.newLine();
        bw.flush();
        client.close();
        
    }
}
