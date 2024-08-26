/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Buffered_Reader_Writer1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author buitu
 */
public class Client721 {
    public static String countChar(String input){
        Map<Character,Integer> mp = new LinkedHashMap <Character, Integer>();  
        for(char c : input.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                mp.put(c, mp.getOrDefault(c,0)+1);  
            }
        }
        String result = "";
        for(Map.Entry<Character,Integer> entry : mp.entrySet()){
            result = result + entry.getKey() + ":" + entry.getValue() + ",";
        }
        return result;
    }
    
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 808);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            Scanner sc = new Scanner(System.in);
            
            String request = "B20DCCN029;721";
            writer.write(request);
            writer.newLine();
            writer.flush();
            
            String receiveStr = reader.readLine();
            System.out.println("Received string from server: " + receiveStr);
            
            writer.write(countChar(receiveStr));
            writer.newLine();
            writer.flush();
            
            socket.close();
        } catch (Exception e) {
            System.out.println("Lỗi:" + e.toString());
        }
    }
}
