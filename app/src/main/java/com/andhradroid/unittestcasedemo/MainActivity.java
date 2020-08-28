package com.andhradroid.unittestcasedemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.andhradroid.unittestcasedemo.mvp.LoginPresenter;
import com.andhradroid.unittestcasedemo.mvp.models.LoginResponse;

public class MainActivity extends AppCompatActivity implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        LoginPresenter loginPresenter = LoginFactory.get()
                .newLoginPresenter(this);
        //
        loginPresenter.doLogin("admin", "admin");

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccess(LoginResponse response) {
        //
    }

    @Override
    public void onError(String message) {
        //
    }

    @Override
    public String getStringResId(int resId) {
        return getString(resId);
    }
}