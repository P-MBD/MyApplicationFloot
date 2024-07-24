package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Log.e("LifeCycle Contact", "onCreate");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle Contact", "onPause");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle Contact", "onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle Contact", "Restart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle Contact", "onResume");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle Contact", "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle Contact", "onDestroy");
    }
}