package com.andhradroid.unittestcasedemo.mvp;

import com.andhradroid.unittestcasedemo.LoginView;
import com.andhradroid.unittestcasedemo.R;
import com.andhradroid.unittestcasedemo.mvp.models.LoginResponse;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static com.andhradroid.unittestcasedemo.ParseUtils.readFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LoginPresenterTest {

    @Mock
    LoginView loginView;

    @Mock
    LoginInteractor loginInteractor;

    TextUtils textUtils;
    LoginPresenter presenter;

    public LoginPresenterTest() {
        textUtils = new TextUtils();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(loginView, loginInteractor, textUtils);
    }

    @After
    public void teardown() throws Exception {
        loginView = null;
    }


    @Test
    public void presenter_NotNull() {
        assertNotNull(loginView);
        assertNotNull(loginInteractor);
        assertNotNull(textUtils);
        assertNotNull(presenter);
    }


    @Test
    public void loginSuccess() {
        presenter.doLogin("admin", "admin");
        Mockito.verify(loginInteractor, Mockito.times(1)).doLogin("admin", "admin", presenter.responseCallback);
    }

    @Test
    public void validationError() {
        Mockito.doReturn("Validation Error")
                .when(loginView).getStringResId(R.string.validation_message);


        presenter.doLogin("", "");

        Mockito.verify(loginView, Mockito.times(1))
                .onError("Validation Error");
    }

    @Test
    public void loginSuccess_Callback() throws IOException {
//        LoginResponse loginResponse = Mockito.mock(LoginResponse.class);
        String jsonString = readFile("/user.json");
        LoginResponse loginResponse = new Gson().fromJson(jsonString, LoginResponse.class);

        presenter.responseCallback.onSuccess(loginResponse);
        Mockito.verify(loginView, Mockito.times(1)).hideProgress();
        Mockito.verify(loginView, Mockito.times(1)).onSuccess(loginResponse);
    }

    @Test
    public void loginError() {
        presenter.responseCallback.onError("Error");
        Mockito.verify(loginView, Mockito.times(1)).onError("Error");
    }

    @Test
    public void testParser() throws IOException {
        String jsonString = readFile("/user.json");
        LoginResponse response = new Gson().fromJson(jsonString, LoginResponse.class);

        assertNotNull(response);
        assertEquals("123", response.getUserId());
    }
}
