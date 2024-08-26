/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.Serializable;

/**
 *
 * @author pc
 */
public class Product937 implements Serializable{
    private static final long serialVersionUID = 937;
    private String id;
    private String code;
    private String name;
    private int quantity;

    public Product937() {
    }

    public Product937(String id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " - Code: " + this.getCode() + " - Name: " + this.getName() + " - Quantity: " + this.getQuantity();
    }
}
