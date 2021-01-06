package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class User_input extends AppCompatActivity {
    EditText editTextName;
    Button btnClickHere;
    TextView textName;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        editTextName = (EditText) findViewById(R.id.editTextName);
        btnClickHere = (Button) findViewById(R.id.btnClickHere);
        textName = (TextView) findViewById(R.id.textName);


        btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                textName.setText("Hi  " + name + " let's begin");
            }
        });
    }


    public void SpinWheel(View view) {
        Intent intent=new Intent(this,List.class);
        startActivity(intent);
    }
}

