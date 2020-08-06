package com.andhradroid.unittestcasedemo.mvp;


import com.andhradroid.unittestcasedemo.LoginView;
import com.andhradroid.unittestcasedemo.R;
import com.andhradroid.unittestcasedemo.mvp.models.LoginResponse;

public class LoginPresenter {

    LoginView loginView;
    LoginInteractor loginInteractor;
    TextUtils mTextUtils;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor, TextUtils textUtils) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
        mTextUtils = textUtils;
    }


    public void doLogin(String username, String password) {
//        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
        if (mTextUtils.isEmpty(username) || mTextUtils.isEmpty(password)) {
//            loginView.onError("Validation Error");
            loginView.onError(loginView.getStringResId(R.string.validation_message));
        } else {
            loginView.showProgress();
            loginInteractor.doLogin(username, password, responseCallback);
        }
    }

    final ResponseCallback<LoginResponse> responseCallback = new ResponseCallback<LoginResponse>() {
        @Override
        public void onSuccess(LoginResponse response) {
            loginView.hideProgress();
            loginView.onSuccess(response);
        }

        @Override
        public void onError(String error) {
            loginView.hideProgress();
            loginView.onError(error);
        }
    };
}
