package com.andhradroid.unittestcasedemo;

public class RetrofitLoginPresenter implements LoginInteractor {
    RetrofitApi mRetrofitApi;

    public RetrofitLoginPresenter(RetrofitApi retrofitApi) {
        mRetrofitApi = retrofitApi;
    }

    @Override
    public void doLogin(String username, String password, Callback<LoginResponse> callback) {
//        mRetrofitApi.service.doLogin()...
    }
}
