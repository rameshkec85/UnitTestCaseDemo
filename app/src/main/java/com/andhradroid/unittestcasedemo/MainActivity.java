package com.andhradroid.unittestcasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.andhradroid.unittestcasedemo.mvp.LoginPresenter;
import com.andhradroid.unittestcasedemo.mvp.LoginResponse;
import com.andhradroid.unittestcasedemo.mvp.RetrofitApi;
import com.andhradroid.unittestcasedemo.mvp.RetrofitLoginPresenter;
import com.andhradroid.unittestcasedemo.mvp.TextUtils;

public class MainActivity extends AppCompatActivity implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        LoginPresenter loginPresenter = new LoginPresenter(this,
                new RetrofitLoginPresenter(new RetrofitApi()),
                new TextUtils());
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