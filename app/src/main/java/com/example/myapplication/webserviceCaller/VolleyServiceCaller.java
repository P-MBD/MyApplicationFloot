package com.example.myapplication.webserviceCaller;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.models.IRequests;
import com.example.myapplication.models.IResponse;

import org.json.JSONArray;

public class VolleyServiceCaller implements IRequests {

    RequestQueue requestQueue;

    public VolleyServiceCaller(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void getBestProducts(IResponse response) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Constants.BEST_APPS, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                response.onResponse(jsonArray.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                response.onFail(volleyError.getMessage().toString());
            }
        });
        requestQueue.add(jsonArrayRequest);


    }

    @Override
    public void getNewProducts(IResponse response) {

    }

    @Override
    public void getAnnouncements(IResponse response) {

    }

    @Override
    public void getCategories(IResponse response) {

    }
}