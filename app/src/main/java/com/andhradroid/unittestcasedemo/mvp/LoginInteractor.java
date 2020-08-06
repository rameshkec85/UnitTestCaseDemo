package com.andhradroid.unittestcasedemo.mvp;

import com.andhradroid.unittestcasedemo.mvp.models.LoginResponse;

public interface LoginInteractor {
    public void doLogin(String username, String password, ResponseCallback<LoginResponse> responseCallback);
}
