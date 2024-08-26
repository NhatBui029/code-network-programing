/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP931;

import java.util.Random;

/**
 *
 * @author AD
 */
public class TT {
    public static void main(String[] args) {
        String s = "requestId;";
        Random g = new Random();
        for(int i = 1; i <=50; i++){
            int c = g.nextInt(50); 
            s += (String.valueOf(c)) + ",";
        }
        s=s.substring(0, s.length()-1);
        System.out.println(s);
            
    }
}
