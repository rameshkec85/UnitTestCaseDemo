package com.andhradroid.unittestcasedemo;

public interface LoginInteractor {
    public void doLogin(String username, String password, Callback<LoginResponse> callback);
}
