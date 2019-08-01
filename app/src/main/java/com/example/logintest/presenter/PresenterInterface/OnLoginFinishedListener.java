package com.example.logintest.presenter.PresenterInterface;

/**
 * 登陆完成的监听器
 */
public interface OnLoginFinishedListener {
    void onUserNameError();
    void onPasswordError();
    void onSuccess();
}
