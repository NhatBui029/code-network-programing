/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS_Number;

import javax.xml.ws.Endpoint;

public class NumberService {
    public static void main(String[] args) {
        String url = "http://localhost:8888/NumberService/Numbers";
        Numbers numberService = new NumberImpl();
        Endpoint.publish(url, numberService);
        System.out.println("Service is published at: " + url);
    }
}
