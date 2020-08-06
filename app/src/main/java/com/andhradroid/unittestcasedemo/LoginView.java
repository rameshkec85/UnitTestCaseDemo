package com.andhradroid.unittestcasedemo;

import com.andhradroid.unittestcasedemo.mvp.models.LoginResponse;

public interface LoginView {

    void showProgress();

    void hideProgress();

    void onSuccess(LoginResponse response);

    void onError(String message);

    String getStringResId(int resId);
}
