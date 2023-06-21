package com.example.shared_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
               boolean check = pref.getBoolean("flag",false);
                Intent inext1;

                if(check){
                    inext1 = new Intent(MainActivity.this, FirstPage.class);
                } else  {
                    inext1 = new Intent(MainActivity.this, HomeActivity.class);
                }

                startActivity(inext1);
            }

        },2000);
    }
}