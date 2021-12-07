package com.example.userlogin.api;

import android.app.Application;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.userlogin.Model;
import com.example.userlogin.User;

import org.json.JSONException;
import org.json.JSONObject;

public class WebAPI implements API {

    public static final String BASE_URL = "http://10.0.2.2:8000/";

    private final Application mApplication;
    private final Model mModel;
    private RequestQueue mRequestQueue;

    public WebAPI(Application application) {
        mApplication = application;
        mRequestQueue = Volley.newRequestQueue(application);
        mModel = Model.getInstance(mApplication);
    }

    public void login(String email, String password, APIListener listener) {
        String url = BASE_URL + "api/login";
        JSONObject jsonObject = new JSONObject();

        // send request to REST API
        try {
            jsonObject.put("email", email);
            jsonObject.put("password", password);

            Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    try {
                        User user = User.getUser(response);
                        listener.onLogin(user);
                    }
                    catch(JSONException e) {
                        Toast.makeText(mApplication, "JSON Exception", Toast.LENGTH_LONG).show();
                    }
                }
            };

            Response.ErrorListener errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(mApplication, "Error response", Toast.LENGTH_LONG).show();
                }
            };

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonObject, successListener, errorListener);
            mRequestQueue.add(request);
        }
        catch (JSONException e) {
            Toast.makeText(mApplication, "Json exception", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}