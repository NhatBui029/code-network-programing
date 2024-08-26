/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP911;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author AD
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2207);
        DataInputStream input = new DataInputStream(client.getInputStream());
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        String maSV = "B18dccn250;911";
        output.writeUTF(maSV);
        int a = input.readInt();
        int b = input.readInt();
        int gcd = GCD(a,b);
        int lcm = a*b/gcd;
        int sum = a+b;
        int tich=a*b;
        output.writeInt(gcd);
        output.writeInt(lcm);
        output.writeInt(sum);
        output.writeInt(tich);
        input.close();
        output.close();
        client.close();
    }
    public  static int GCD(int a, int b){
        return (b == 0)?a:GCD(b, a%b);
    }
}
