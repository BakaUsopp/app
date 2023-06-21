package com.example.shared_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    Button btnsig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnsig = findViewById(R.id.btnsig);
        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref= getSharedPreferences("sign",MODE_PRIVATE);
                SharedPreferences.Editor editor= pref.edit();
                editor.putBoolean("sign",false);
                editor.apply();
                boolean check = pref.getBoolean("sign",false);
                Intent inext1;
                if(check){
                    inext1 = new Intent(SignUp.this, MainActivity.class);
                } else  {
                    inext1 = new Intent(SignUp.this, login.class);
                }
                startActivity(inext1);

            }
        });
    }
}