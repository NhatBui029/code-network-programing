/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Arrays;
import java.util.Collections;
import ws1.Numbers;
import ws1.NumberImplService;

/**
 *
 * @author buitu
 */
public class Main {
    public static void main(String[] args) {
        try {
            NumberImplService numberService = new NumberImplService();
            Numbers numbers = numberService.getNumberImplPort();
            String input = numbers.getNumber().trim();
            String[] inputArray = input.split("\\;");
            String id = inputArray[0];
            String[] list = inputArray[1].trim().split("\\,");
            Arrays.sort(list, Collections.reverseOrder());
            String result ="";
            for(String s: list){
                result += s;
            }
            System.out.println(result);
            numbers.greatestNumber(id, result);
        } catch (Exception e) {
        }
    }
}
