package com.example.logintest.interactor.InteractorImpl;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.example.logintest.interactor.InteractorInterface.LoginInteractor;
import com.example.logintest.presenter.PresenterInterface.OnLoginFinishedListener;

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String userName, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("ZhiXueHui", "LoginInteractorImpl-login");
                boolean error = false;
                if(TextUtils.isEmpty(userName)){
                    listener.onUserNameError();
                    error = true;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if(!error){
                    listener.onSuccess();
                }
            }
        },2000);
    }
}
