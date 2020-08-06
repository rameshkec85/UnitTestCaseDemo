package com.andhradroid.unittestcasedemo.mvp;

public interface LoginInteractor {
    public void doLogin(String username, String password, ResponseCallback<LoginResponse> responseCallback);
}
