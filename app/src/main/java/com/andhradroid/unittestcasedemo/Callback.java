package com.andhradroid.unittestcasedemo;

public interface Callback<T> {
    void onSuccess(T response);

    void onError(String error);
}
