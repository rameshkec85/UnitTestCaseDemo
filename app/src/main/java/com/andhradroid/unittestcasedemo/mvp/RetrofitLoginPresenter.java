package com.andhradroid.unittestcasedemo.mvp;

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
