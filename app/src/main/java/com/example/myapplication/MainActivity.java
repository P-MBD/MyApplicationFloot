package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.activity.ContactActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageSlider;
    Button btn_home, btn_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("LifeCycle Main", "OnCreate");
        imageSlider = (ImageView) findViewById(R.id.img_slider);
        btn_home = (Button) findViewById(R.id.btn_home);
        btn_contact = (Button)findViewById(R.id.btn_contact);
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("LifeCycle Main","on click for test");
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.contact_message), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle Main", "onPause");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle Main", "onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle Main", "Restart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle Main", "onResume");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle Main", "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle Main", "onDestroy");
    }
}

