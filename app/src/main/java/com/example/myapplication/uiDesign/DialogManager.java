package com.example.myapplication.uiDesign;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.myapplication.R;

public class DialogManager {
    public  static  void  loginUI(Activity activity){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.login_dialog, null);
        EditText edt_userName = (EditText)view.findViewById(R.id.edt_userName);
        EditText edt_password = (EditText)view.findViewById(R.id.edt_password);
        Button btn_login = (Button)view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edt_userName.getText().toString();
                Toast.makeText(activity,userName,Toast.LENGTH_LONG).show();
            }
        });
        alert.setView(view);
        alert.show();
    }
}

