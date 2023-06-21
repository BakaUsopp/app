package com.example.shared_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Gallary extends AppCompatActivity {
    TextView text1, text2, text3,textid;
    ListView listView;
    ArrayList<String> arrNames = new ArrayList<>();
    SearchView search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        TextView text1 = (TextView) findViewById(R.id.text1);
        TextView text2 = (TextView) findViewById(R.id.text2);
        TextView text3 = (TextView) findViewById(R.id.text3);


        listView = (ListView) findViewById(R.id.listView);
        search =findViewById(R.id.search);
        search.clearFocus();

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                fileList(newText);
                return true;

            }
        });




        arrNames.add("luffy_is_eating");
        arrNames.add("little_luffy");
        arrNames.add("manga_chapter");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (arrNames.toString().equals("luffy_is_eating")) {
                    SharedPreferences pref = getSharedPreferences("gallery", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("gallery", true);
                    editor.apply();
                    boolean check = pref.getBoolean("gallery", false);
                    Intent intent1;
                    if (check) {
                        intent1 = new Intent(Gallary.this, luffy2.class);
                    } else {
                        intent1 = new Intent(Gallary.this, Long.class );
                    }
                    startActivity(intent1);

                }
            }
        });


        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("gallery", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("gallery", true);
                editor.apply();
                boolean check = pref.getBoolean("gallery", false);
                Intent intent1;
                if (check) {
                    intent1 = new Intent(Gallary.this, HomeActivity.class);
                } else {
                    intent1 = new Intent(Gallary.this, login.class);
                }
                startActivity(intent1);

            }
        });


    }

    private void fileList(String newText) {
        ArrayList<String> filterList = new ArrayList<>();
        for(String string : arrNames){
            if(string.getBytes().equals(arrNames.toArray().length)){

            }
        }
    }
}
