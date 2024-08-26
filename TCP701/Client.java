/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP701;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author AD
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("Localhost", 1234);
        System.out.println("Connected to server");
        InputStream input = new DataInputStream(clientSocket.getInputStream());
        OutputStream output = new DataOutputStream(clientSocket.getOutputStream());
        //gui ma
        String ma = "B18DCCN250;701";
        output.write(ma.getBytes());
        output.flush();
        // nhan chuoi
        byte[] rc = new byte[65536];
        input.read(rc);
        String nhan = new String(rc).trim();
        List<Integer> a = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(nhan, ",");
        while(tokenizer.hasMoreTokens()){
            a.add(Integer.parseInt(tokenizer.nextToken()));
        }
        
        String kq = "";
        int min = 9999;
        Collections.sort(a);
        for(int i = a.size()-1; i > 0; i--){
            for(int j = i-1; j >= 0; j--){
                int t = a.get(i)-a.get(j);
                if(a.contains(t) && t < min){
                    min = t ;
                    kq ="";
                    kq+=t+","+a.get(j)+","+a.get(i);
                }
            }
        }
        System.out.println(kq);
        // gui kq
        output.write(kq.getBytes());
        output.flush();
        clientSocket.close();
    }
}
