package com.example.myapplication.webserviceCaller;



import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.models.IRequests;
import com.example.myapplication.models.IResponse;
import com.example.myapplication.models.User;


import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Android on 3/9/2018.
 */

public class VolleyServiceCaller implements IRequests {

    RequestQueue requestQueue;

    public VolleyServiceCaller(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }


    @Override
    public void getBestProducts(final IResponse response) {


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Constants.BEST_APPS, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    response.onResponse(jsonArray.toString());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
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
    public void getNewProducts(final IResponse response) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.NEW_APPS, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    response.onResponse(s);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                response.onFail(volleyError.getMessage().toString());
            }
        });


        requestQueue.add(stringRequest);

    }


    @Override
    public void getAnnouncements(IResponse response) {

    }

    @Override
    public void getCategories(IResponse response) {

    }

    @Override
    public void register(final User user, final IResponse iResponse)  {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s)  {
                        try {
                            iResponse.onResponse(s);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        iResponse.onFail(volleyError.getMessage());
                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", user.getUserName());
                params.put("password", user.getPassword());
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }




}
