package com.andhradroid.unittestcasedemo.mvp;

public interface ResponseCallback<T> {
    void onSuccess(T response);

    void onError(String error);
}
