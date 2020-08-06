package com.andhradroid.unittestcasedemo.mvp;

import com.andhradroid.unittestcasedemo.mvp.models.LoginResponse;

public class RetrofitLoginPresenter implements LoginInteractor {
    RetrofitApi mRetrofitApi;

    public RetrofitLoginPresenter(RetrofitApi retrofitApi) {
        mRetrofitApi = retrofitApi;
    }

    @Override
    public void doLogin(String username, String password, ResponseCallback<LoginResponse> responseCallback) {
//        mRetrofitApi.service.doLogin()...
    }
}
