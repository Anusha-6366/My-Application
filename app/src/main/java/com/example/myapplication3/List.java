package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class List extends AppCompatActivity {
    int[] image = new int[]{
            R.drawable.yes, R.drawable.spi9,R.drawable.exp1,R.drawable.h1
    };
    String[] headline = new String[]{
            "Decision making","Numbers", "Expressions","Wheel of dares"
    };
    String[] stat = new String[]{
            "Yes/No",  "Contains numbers upto nine",  "Facial expressions","How often do u....?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = findViewById(R.id.list);
        java.util.List<HashMap<String, String>> list = new ArrayList<>();
        for (int i = 0; i <4; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("image", Integer.toString(image[i]));
            hashMap.put("headline", headline[i]);
            hashMap.put("stat", stat[i]);
            list.add(hashMap);
        }
        String[] from = {"image", "headline", "stat"};
        int[] to = {R.id.imageView, R.id.textView2, R.id.textview3};
        SimpleAdapter simple = new SimpleAdapter(getBaseContext(), list, R.layout.listview, from, to);
        listView.setAdapter(simple);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Yesn.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), SpinningActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Expression.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(view.getContext(), Dare.class);
                    startActivity(intent);
                }


                Toast.makeText(List.this, headline[position], Toast.LENGTH_SHORT).show();


            }

        });

    }
}