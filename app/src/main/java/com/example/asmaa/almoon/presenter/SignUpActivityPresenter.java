package com.example.asmaa.almoon.presenter;

import android.content.Context;

import com.example.asmaa.almoon.Model.User;
import com.example.asmaa.almoon.view.activity.ISignUpActivityView;
import com.example.asmaa.almoon.view.activity.SignUpActivity;

/**
 * Created by Asmaa on 10/6/2017.
 */

public class SignUpActivityPresenter implements ISignUpActivityPresenter {
    private Context mContext;
    private ISignUpActivityView mIView;
    User user;
    public SignUpActivityPresenter(Context context,ISignUpActivityView iview){
        this.mContext=context;
        this.mIView=iview;
    }

    @Override
    public void signUp() {
        user=new User();
        user.setFname(mIView.getFname());
        user.setLname(mIView.getLname());
        user.setCode(mIView.getCode());
        user.setPhone(mIView.getPhone());
        user.setEmail(mIView.getEmail());
        user.setPassword(mIView.getPassword());
        user.setConfirmPassword(mIView.getConPass());
//volley or retrofit


    }
}
