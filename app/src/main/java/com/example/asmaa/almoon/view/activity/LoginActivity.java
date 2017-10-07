package com.example.asmaa.almoon.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.asmaa.almoon.R;
import com.example.asmaa.almoon.presenter.LoginActivityPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginActivityView{

    LoginActivityPresenter mLoginActivityPresenter;
EditText ed_email;
    EditText ed_password;
    Button btn_login;
    TextView tv_createAccount;
    TextView tv_forgetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_email=(EditText)findViewById(R.id.ed_email);
        ed_password=(EditText)findViewById(R.id.ed_password);
        btn_login=(Button)findViewById(R.id.btn_login);
        tv_createAccount=(TextView)findViewById(R.id.tv_createAccount);
        tv_forgetPassword=(TextView)findViewById(R.id.tv_forget);

        mLoginActivityPresenter=new LoginActivityPresenter(this,this);

        tv_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public String getEmail() {
        return ed_email.getText().toString();
    }

    @Override
    public String getPassword() {
        return ed_password.getText().toString();
    }
}
