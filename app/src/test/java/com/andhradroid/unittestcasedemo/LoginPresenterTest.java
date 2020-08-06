package com.andhradroid.unittestcasedemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


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
        Assert.assertNotNull(loginView);
        Assert.assertNotNull(loginInteractor);
        Assert.assertNotNull(textUtils);
        Assert.assertNotNull(presenter);
    }


    @Test
    public void loginSuccess() {
        presenter.doLogin("admin", "admin");
        Mockito.verify(loginInteractor, Mockito.times(1)).doLogin("admin", "admin", presenter.callback);
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
    public void loginSuccess_Callback() {
        LoginResponse loginResponse = Mockito.mock(LoginResponse.class);
        presenter.callback.onSuccess(loginResponse);
        Mockito.verify(loginView, Mockito.times(1)).hideProgress();
        Mockito.verify(loginView, Mockito.times(1)).onSuccess(loginResponse);
    }

    @Test
    public void loginError() {
        presenter.callback.onError("Error");
        Mockito.verify(loginView, Mockito.times(1)).onError("Error");
    }
}
