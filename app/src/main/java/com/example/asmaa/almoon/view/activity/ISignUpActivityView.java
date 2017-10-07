package com.example.asmaa.almoon.view.activity;

/**
 * Created by Asmaa on 10/6/2017.
 */

public interface ISignUpActivityView {
    public String getFname();
    public String getLname();
    public String getPassword();
    public String getConPass();
    public String getCode();
    public String getPhone();
    public String getEmail();
    public boolean isValidEmail(CharSequence target);
    public boolean isValidCellPhone(String number);
}
