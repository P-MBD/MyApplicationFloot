package com.example.myapplication.models;

public interface IResponse {

    public void onResponse(String message);
    public void onFail(String errorMessage);

}
