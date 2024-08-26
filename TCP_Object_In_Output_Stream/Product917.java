/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_In_Output_Stream;

import java.io.Serializable;

/**
 *
 * @author buitu
 */
public class Product917 implements  Serializable{
    private static final long serialVersionUID = 917;
    
    private int id,quantity;
    private String name,code;

    public Product917(int id, String code , String name,int quantity) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product917{" + "id=" + id + ", quantity=" + quantity + ", name=" + name + ", code=" + code + '}';
    }        
    
}
