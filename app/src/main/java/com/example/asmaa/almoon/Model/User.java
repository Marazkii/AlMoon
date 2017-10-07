package com.example.asmaa.almoon.Model;

/**
 * Created by Asmaa on 10/6/2017.
 */

public class User {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String code;
    private String phone;
    private String confirmPassword;

    public String getCode() {
        return code;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
