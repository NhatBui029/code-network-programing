/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rmi.laptrinhmang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author buitu
 */
public class LapTrinhMang {

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('8');
        list.add('9');
        list.add('b');list.add('0');
        list.add('z');
        
        System.out.println(Collections.max(list));
        
    }
}
