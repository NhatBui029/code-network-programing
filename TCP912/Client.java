/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP912;

import com.sun.media.sound.DLSModulator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.Buffer;

/**
 *
 * @author AD
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 1234);
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        
        // gui len server
        String ma = "B18DCCN250;912";
        bw.write(ma);
        bw.newLine();
        bw.flush();
        // nhan tu server
        String s = br.readLine();
        String s1="",s2="";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z')||(c >= 'A'&&c <= 'Z')||(c >='0' && c <='9')){
                s1+=c;
            }
            else s2+=c;  
        }
        System.out.println(s1+" "+s2);
        // gui len server
//        String ma = "B18DCCN250;912";
        bw.write(s1);
        bw.newLine();
        bw.flush();
        bw.write(s2);
        bw.newLine();
        bw.flush();
    }
}
