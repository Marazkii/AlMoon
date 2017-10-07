package com.example.asmaa.almoon.presenter;


import android.content.Context;
import android.content.Intent;

import com.example.asmaa.almoon.Model.User;
import com.example.asmaa.almoon.view.activity.ILoginActivityView;

/**
 * Created by Asmaa on 10/6/2017.
 */

public class LoginActivityPresenter implements ILoginActivityPresenter {
    private Context mContext;
    private ILoginActivityView mIView;
    User user;
    public LoginActivityPresenter(Context context,ILoginActivityView iview){
        this.mContext=context;
        this.mIView=iview;
    }


    @Override
    public void login() {
        user=new User();
        user.setEmail(mIView.getEmail());
        user.setPassword(mIView.getPassword());
        //volley or retrofit
    }
}
