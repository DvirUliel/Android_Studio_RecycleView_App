package com.example.mysecondproject.models;

public class Student {
    private String email;
    private String phone;

    public Student(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public Student() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
