/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author pc
 */
public class TCP_918 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("203.162.10.109", 2209);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            String sendMes = "B18DCCN411;918";
            oos.writeObject(sendMes);
            oos.flush();

            Customer918 cus = (Customer918) ois.readObject();
            System.out.println(cus);
            
            String name = cus.getName();
            name = name.replaceAll("\\s+", " "); 
            String dOb = cus.getDayOfBirth();

            String[] split = name.split(" ");
            String lastName = split[split.length - 1];
            StringBuilder nameBuilder = new StringBuilder();
            StringBuilder userNameBuilder = new StringBuilder();
            for (int i = 0; i < lastName.length(); i++) {
                nameBuilder.append(Character.toUpperCase(lastName.charAt(i)));
            }
            nameBuilder.append(", ");
            for (int i = 0; i < split.length - 1; i++) {
                String tmp = split[i];

                nameBuilder.append(Character.toUpperCase(tmp.charAt(0)));
                userNameBuilder.append(Character.toLowerCase(tmp.charAt(0)));

                for (int j = 1; j < tmp.length(); j++) {
                    nameBuilder.append(Character.toLowerCase(tmp.charAt(j)));
                }
                nameBuilder.append(" ");
            }
            for (int i = 0; i < lastName.length(); i++) {
                userNameBuilder.append(Character.toLowerCase(lastName.charAt(i)));
            }
            nameBuilder.deleteCharAt(nameBuilder.length() - 1);
            cus.setName(nameBuilder.toString());
            cus.setUserName(userNameBuilder.toString());

            String[] split1 = dOb.split("-");
            StringBuilder dObBuilder = new StringBuilder();
            dObBuilder.append(split1[1]).append("/").append(split1[0]).append("/").append(split1[2]);
            cus.setDayOfBirdth(dObBuilder.toString());

            System.out.println(cus);
            oos.writeObject(cus);

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
