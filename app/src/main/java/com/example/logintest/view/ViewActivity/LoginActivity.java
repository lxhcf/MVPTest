package com.example.logintest.view.ViewActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.logintest.MainActivity;
import com.example.logintest.R;
import com.example.logintest.presenter.PresenterImpl.LoginPresenterImpl;
import com.example.logintest.presenter.PresenterInterface.LoginPresenter;
import com.example.logintest.view.ViewInterface.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener{
    private EditText userName;
    private EditText password;
    private Button button;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i("ZhiXueHui", "LoginActivity-onCreate");
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener((View.OnClickListener) this);

        presenter = new LoginPresenterImpl((LoginView) this);

    }
    @Override
    public void setUserNameError() {
        Log.i("ZhiXueHui", "LoginActivity-setUserNameError");
        userName.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        Log.i("ZhiXueHui", "LoginActivity-setPasswordError");
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        Log.i("ZhiXueHui", "LoginActivity-navigateToHome");
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        Log.i("ZhiXueHui", "LoginActivity-onClick");
        presenter.validateCredentials(userName.getText().toString(), password.getText().toString());
    }
}
