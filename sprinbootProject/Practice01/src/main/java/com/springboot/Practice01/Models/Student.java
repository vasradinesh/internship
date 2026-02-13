package com.springboot.Practice01.Models;

public class Student {
    private  int id;
    private String name;
    private String address;
    private String pincode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return address;
    }

    public void setAddres(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Student(int id, String name, String address, String pincode) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addres='" + address + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }

    public Student() {
    }
}
