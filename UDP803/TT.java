/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP803;

/**
 *
 * @author AD
 */
public class TT {
    public static void main(String[] args) {
        String s = "requestId;dsfgdfgdfg";
        String[] s1 = s.split(";");
        System.out.println(s1[1]);
        StringBuilder xau = new StringBuilder(s1[0]+";");
        int dem[] = new int[256];
        int len = s1[1].length();
        for(int i = 0; i < len; i++){
            dem[s1[1].charAt(i)]++;
        }
        int max = 0;
        char maxvalue = 'C';
        for(int i =0 ; i < len; i++){
            if(dem[s1[1].charAt(i)] > max){
                max = dem[s1[1].charAt(i)];
                maxvalue = s1[1].charAt(i);
            }
        }
        boolean t = true;
        for(int i = 0; i < len; i++){
            char c = s1[1].charAt(i);
            if(dem[s1[1].charAt(i)] == max && c == maxvalue){
                if(t)   xau.append(s1[1].charAt(i)+ ":");
                t = false;
                xau.append(i+",");
            }
        }
        String kq = xau.toString();
        System.out.println(kq);
    }
}
