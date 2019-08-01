package com.example.logintest.presenter.PresenterImpl;

import android.util.Log;

import com.example.logintest.interactor.InteractorImpl.LoginInteractorImpl;
import com.example.logintest.interactor.InteractorInterface.LoginInteractor;
import com.example.logintest.presenter.PresenterInterface.LoginPresenter;
import com.example.logintest.presenter.PresenterInterface.OnLoginFinishedListener;
import com.example.logintest.view.ViewInterface.LoginView;

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String userName, String password) {
        Log.i("ZhiXueHui", "LoginPresenterImpl-validateCredentials");
        loginInteractor.login(userName,password,this);
    }


    @Override
    public void onDestroy() {
        Log.i("ZhiXueHui", "LoginPresenterImpl-onDestroy");
        loginView = null;
    }

    @Override
    public void onUserNameError() {
        Log.i("ZhiXueHui", "LoginPresenterImpl-onUserNameError");
        if(loginView!=null){
            loginView.setUserNameError();
        }
    }

    @Override
    public void onPasswordError() {
        Log.i("ZhiXueHui", "LoginPresenterImpl-onPasswordError");
        if(loginView!=null){
            loginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        Log.i("ZhiXueHui", "LoginPresenterImpl-onSuccess");
        if(loginView!=null){
            loginView.navigateToHome();
        }
    }
}
