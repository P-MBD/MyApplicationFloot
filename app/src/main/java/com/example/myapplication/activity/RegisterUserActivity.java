package com.example.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.UserDbAdapter;
import com.example.myapplication.models.User;
import com.google.android.material.snackbar.Snackbar;

public class RegisterUserActivity extends AppCompatActivity {


    EditText input_email,input_password;
    Button btn_register;

    UserDbAdapter userDbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        input_email=(EditText)findViewById(R.id.input_email);
        input_password=(EditText)findViewById(R.id.input_password);
        btn_register=(Button)findViewById(R.id.btn_register);

        userDbAdapter=new UserDbAdapter(getApplicationContext());

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user=new User();

                user.setPassword(input_password.getText().toString());
                user.setUserName(input_email.getText().toString());

                long result=userDbAdapter.insertUser(user);

                if(result>0){
                    Snackbar.make(view,getResources().getString(R.string.success_register),
                            Snackbar.LENGTH_LONG).show();
                }else {
                    Snackbar.make(view,getResources().getString(R.string.success_fail),
                            Snackbar.LENGTH_LONG).show();
                }


            }
        });

    }
}
