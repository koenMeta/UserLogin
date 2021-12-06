package com.example.userlogin;

import android.app.Application;

import com.example.userlogin.api.API;
import com.example.userlogin.api.WebAPI;

public class Model implements API {

    private static Model sInstance = null;
    private final API mApi;

    public static Model getInstance(Application application) {
        if (sInstance == null) {
            sInstance = new Model(application);
        }
        return sInstance;
    }

    private final Application mApplication;

    private Model(Application application) {
        mApplication = application;
        // Set the API type. Could be changed to DbAPI, for instance.
        mApi = new WebAPI(mApplication);
    }

    public Application getApplication() {
        return mApplication;
    }

    public void login(String email, String password) {
        mApi.login(email, password);
    }
}
