package com.example.myapplication.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication.models.User;

public class LoginManagement {
    Context context;
    SharedPreferences sh;
    SharedPreferences.Editor editor;

    public LoginManagement(Context context){
        this.context = context;
        sh = context.getSharedPreferences("loginData", Context.MODE_PRIVATE);
        editor = sh.edit();
    }

    public  void saveData(User user){
        editor.putString("userName", user.getUserName());
        editor.putString("password", user.getPassword());
        editor.commit();
    }
    public String getUserName(){
        return  sh.getString("username","");
    }

    public  String getPassword(){
        return  sh.getString("password","");
    }

}
