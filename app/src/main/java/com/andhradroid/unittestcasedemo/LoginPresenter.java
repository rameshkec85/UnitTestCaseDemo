package com.andhradroid.unittestcasedemo;


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
            loginInteractor.doLogin(username, password, callback);
        }
    }

    final Callback<LoginResponse> callback = new Callback<LoginResponse>() {
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
