package com.example.myapplication.models;

public interface IResponse {

    public void onResponse(String message) throws Exception;
    public void onFail(String errorMessage);

}
