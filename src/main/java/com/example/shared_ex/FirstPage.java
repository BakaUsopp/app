package com.example.shared_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FirstPage extends AppCompatActivity {
Button btn3;
TextView btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("page", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("page", false);
                editor.apply();


                boolean check = pref.getBoolean("page", false);
                Intent inext1;
                if (check) {
                    inext1 = new Intent(FirstPage.this, FirstPage.class);
                } else {
                    inext1 = new Intent(FirstPage.this, SignUp.class);
                }
                startActivity(inext1);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("page", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("page", false);
                editor.apply();

                boolean check = pref.getBoolean("page", false);
                Intent inext1;
                if (check) {
                    inext1 = new Intent(FirstPage.this, FirstPage.class);
                } else {
                    inext1 = new Intent(FirstPage.this, login.class);
                }
                startActivity(inext1);
            }

        });
    }
}