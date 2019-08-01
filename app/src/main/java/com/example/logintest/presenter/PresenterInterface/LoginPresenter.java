package com.example.logintest.presenter.PresenterInterface;

/**
 * 登陆的控制器
 */
public interface LoginPresenter {
    void validateCredentials(String userName,String password);
    void onDestroy();
}
