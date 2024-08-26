/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_In_Output_Stream1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author buitu
 */
public class Client {

    public static String countChar(String input) {
        Map<Character, Integer> mp = new LinkedHashMap<>();
        for (Character c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                mp.put(c, mp.getOrDefault(c, 0) + 1);
            }
        }
        StringBuilder result = new StringBuilder();
        mp.entrySet().stream()
//                .sorted(Map.Entry.<Character, Integer>comparingByKey())
                .sorted(Map.Entry.<Character, Integer>comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> result.append(entry.getKey()).append(":").append(entry.getValue()).append(","));
        result.deleteCharAt(result.length() - 1);
//        String kq = "";
//        for(Map.Entry<Character, Integer> e : mp.entrySet()) kq+=e.getKey()+":"+e.getValue()+";";
        return result.toString();
    }

    public static void main(String[] args) {
        try {
            Socket client = new Socket("192.168.228.204", 808);
            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();

            os.write("B20DCCN029;721".getBytes());

            byte[] receiveByte = new byte[1024];
            is.read(receiveByte);
            String receiveStr = new String(receiveByte);
            String[] receiveArr = receiveStr.trim().split("\\;");
            String requestId = receiveArr[0];
            String input = receiveArr[1].trim();
            String result = countChar(input);
            System.out.println(result);

            os.write((requestId+";"+result).getBytes());
            client.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
