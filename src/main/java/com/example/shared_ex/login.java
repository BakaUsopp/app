package com.example.shared_ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class login extends AppCompatActivity {
    Button btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn2 = findViewById(R.id.btn2);
        EditText email = (EditText) findViewById(R.id.Email);
        EditText pass = (EditText) findViewById(R.id.Pass);

        btn2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("Admin") && pass.getText().toString().equals("Admin")) {
                    Toast.makeText(login.this, "Login success", Toast.LENGTH_SHORT).show();
                    SharedPreferences pref = getSharedPreferences("flag", MODE_PRIVATE);
                    SharedPreferences.Editor editor= pref.edit();
                    editor.putBoolean("flag",true);
                    editor.apply();


                    boolean check = pref.getBoolean("login",false);

                    Intent inext1;
                    if(check){
                        inext1 = new Intent(login.this, FirstPage.class);
                    } else  {
                        inext1 = new Intent(login.this, Gallary.class);
                    }
                    startActivity(inext1);

                }else{
                    Toast.makeText(login.this, "Login unsuccessfull", Toast.LENGTH_SHORT).show();
                }
            }
        });

/*btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("flag", MODE_PRIVATE);
                SharedPreferences.Editor editor= pref.edit();
                editor.putBoolean("flag",true);
                editor.apply();

                boolean check = pref.getBoolean("login",false);

                Intent inext1;
                if(check){
                    inext1 = new Intent(login.this, FirstPage.class);
                } else  {
                    inext1 = new Intent(login.this, Gallary.class);
                }
                startActivity(inext1);

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                btn2.startAnimation(animation);


            }
        });*/






    }
}