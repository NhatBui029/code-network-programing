/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author AD
 */
public class Student implements Serializable{
    private int id;
    private String code;
    private float gpa;
    private String gpaletter;

    public Student() {
    }

    public Student(int id, String code, float gpa, String gpaletter) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
        this.gpaletter = gpaletter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getGpaletter() {
        return gpaletter;
    }

    public void setGpaletter(String gpaletter) {
        this.gpaletter = gpaletter;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", gpa=" + gpa + ", gpaletter=" + gpaletter + '}';
    }
    
    
}
