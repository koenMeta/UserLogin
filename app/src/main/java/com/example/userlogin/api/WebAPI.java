package com.example.userlogin.api;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class WebAPI implements API {

    public static final String BASE_URL = "http://10.0.2.2:8000/";

    private RequestQueue mRequestQueue;

    public WebAPI(Application application) {
        mRequestQueue = Volley.newRequestQueue(application);
    }

    public void login(String email, String password) {
        // send request to REST API
        Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

            }
        };


//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "",  null, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                textView.setText("Response: " + response.toString());
//            }
//        };
    }

}