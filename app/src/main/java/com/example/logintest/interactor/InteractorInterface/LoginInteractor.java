package com.example.logintest.interactor.InteractorInterface;

import com.example.logintest.presenter.PresenterInterface.OnLoginFinishedListener;

/**
 * 登陆的模型
 */
public interface LoginInteractor {
    void login(String userName, String password, OnLoginFinishedListener listener);

}
