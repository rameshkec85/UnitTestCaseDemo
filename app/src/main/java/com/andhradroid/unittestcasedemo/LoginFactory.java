package com.andhradroid.unittestcasedemo;

import com.andhradroid.unittestcasedemo.mvp.LoginInteractor;
import com.andhradroid.unittestcasedemo.mvp.LoginPresenter;
import com.andhradroid.unittestcasedemo.mvp.RetrofitApi;
import com.andhradroid.unittestcasedemo.mvp.RetrofitLoginPresenter;
import com.andhradroid.unittestcasedemo.mvp.TextUtils;

public class LoginFactory {
    LoginInteractor mLoginInteractor;
    TextUtils mTextUtils;
    RetrofitApi retrofitApi;

    public static LoginFactory get() {
        return new LoginFactory();
    }

    private LoginFactory() {
        retrofitApi = new RetrofitApi();
        mLoginInteractor = new RetrofitLoginPresenter(retrofitApi);
        mTextUtils = new TextUtils();
    }

    public LoginPresenter newLoginPresenter(LoginView loginView) {
        return new LoginPresenter(loginView,
                mLoginInteractor,
                mTextUtils
        );
    }

}
