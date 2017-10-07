package com.example.asmaa.almoon.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asmaa.almoon.R;
import com.example.asmaa.almoon.presenter.SignUpActivityPresenter;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity implements ISignUpActivityView {

    SignUpActivityPresenter mSignUpActivityPresenter;
    TextView tv_login;
    EditText ed_email,ed_fname,ed_lname,ed_phone,ed_code,ed_password,ed_conPass;
    Button btn_signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        tv_login=(TextView)findViewById(R.id.tv_login);
        ed_email=(EditText)findViewById(R.id.ed_email);
        ed_fname=(EditText)findViewById(R.id.ed_fname);
        ed_password=(EditText)findViewById(R.id.ed_password);
        ed_conPass=(EditText)findViewById(R.id.ed_confirmPassword);
        ed_lname=(EditText)findViewById(R.id.ed_lname);
        ed_code=(EditText)findViewById(R.id.ed_code);
        ed_phone=(EditText)findViewById(R.id.ed_phone);
        btn_signUp=(Button)findViewById(R.id.btn_signUp);


        mSignUpActivityPresenter=new SignUpActivityPresenter(this,this);

    btn_signUp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if(ed_fname.length()==0){
            ed_fname.setError("Required Field!");
            ed_fname.setFocusable(true);}
        else if(!(Pattern.matches("^[\\p{L} .'-]+$", ed_fname.getText().toString()))){
            ed_fname.setError("Allow only spaces and letters");
            ed_fname.setFocusable(true);}

        if(ed_lname.length()==0){
            ed_lname.setError("Required Field!");
            ed_lname.setFocusable(true);}
        else if(!(Pattern.matches("^[\\p{L} .'-]+$", ed_lname.getText().toString()))){
            ed_lname.setError("Allow only spaces and letters");
            ed_lname.setFocusable(true);}

        if (ed_email.length() == 0){
            ed_email.setError("Required Field!");
            ed_email.setFocusable(true);}
        else if(!(isValidEmail(ed_email.getText().toString()))){
            ed_email.setError("Invalid Email Address");
            ed_email.setFocusable(true);}

        if(ed_phone.length() == 0){
            ed_phone.setError("Required Field!");
            ed_phone.setFocusable(true);}
        else if(ed_phone.length() != 11 || !(ed_phone.getText().toString().startsWith("01")) || !(isValidCellPhone(ed_phone.getText().toString()))){
            ed_phone.setError("Incorrect Phone Number");
            ed_phone.setFocusable(true);}

        if(ed_password.length()==0){
            ed_password.setError("Required Field!");
            ed_password.setFocusable(true);}
        else if(ed_password.length() < 8) {
            ed_password.setError("Minimum 8 digits");
            ed_password.setFocusable(true);}

        if(ed_conPass.length()==0){ed_conPass.setError("Required Field!");}
        else if(!(ed_conPass.getText().toString().equals(ed_password.getText().toString()))){
            ed_conPass.setError("Not Matched");
        }

        if((ed_fname.length()!=0)&&(Pattern.matches("^[\\p{L} .'-]+$", ed_fname.getText().toString()))&&
                (ed_lname.length()!=0)&&(Pattern.matches("^[\\p{L} .'-]+$", ed_lname.getText().toString()))&&
                (ed_email.length() != 0)&&(isValidEmail(ed_email.getText().toString()))&&
                (ed_phone.length() != 0)&&(ed_phone.length()==11)&&(ed_phone.getText().toString().startsWith("01"))&&
                (isValidCellPhone(ed_phone.getText().toString()))&&(ed_password.length()!=0)&&(ed_password.length() >= 8)&&
                (ed_password.getText().toString().equals(ed_conPass.getText().toString()))) {

            //calling registration function
            mSignUpActivityPresenter.signUp();
        }
        else {
            Toast.makeText(SignUpActivity.this, "Unable to register", Toast.LENGTH_SHORT).show();}
    }

   });
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public String getFname() {
        return ed_fname.getText().toString();
    }

    @Override
    public String getLname() {
        return ed_lname.getText().toString();
    }

    @Override
    public String getPassword() {
        return ed_password.getText().toString();
    }

    @Override
    public String getConPass() {
        return ed_conPass.getText().toString();
    }

    @Override
    public String getCode() {
        return ed_code.getText().toString();
    }

    @Override
    public String getPhone() {
        return ed_phone.getText().toString();
    }

    @Override
    public String getEmail() {
        return ed_email.getText().toString();
    }

    @Override
    public boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();}

    @Override
    public boolean isValidCellPhone(String number) {
        return android.util.Patterns.PHONE.matcher(number).matches();}

    }
