package com.bawei.dayds_20;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MyVolley {
    private static final MyVolley ourInstance = new MyVolley();

    public static MyVolley getInstance() {
        return ourInstance;
    }

    private MyVolley() {
    }

    public void getVolley(Context context, String url, final Icunt.Callback callback){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                  callback.getData(response);
            }
        },null);
        queue.add(request);
    }

}
