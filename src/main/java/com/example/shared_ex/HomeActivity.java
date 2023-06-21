package com.example.shared_ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
public class HomeActivity extends AppCompatActivity {


Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn1 = findViewById(R.id.btn1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref= getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor= pref.edit();
                editor.putBoolean("login",false);
                editor.apply();
                boolean check = pref.getBoolean("login",false);
                Intent inext1;
                if(check){
                    inext1 = new Intent(HomeActivity.this, login.class);
                } else  {
                    inext1 = new Intent(HomeActivity.this, FirstPage.class);
                }
                startActivity(inext1);


            }
        });
    }
}
