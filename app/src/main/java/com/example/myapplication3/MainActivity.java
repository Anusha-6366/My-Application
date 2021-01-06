package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import static java.lang.Thread.sleep;

        public class MainActivity extends AppCompatActivity {
            MediaPlayer mp;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                mp=MediaPlayer.create(MainActivity.this,R.raw.welcome);
                mp.start();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(7000);
                            Intent i=new Intent(MainActivity.this,MainActivity3.class);
                            startActivity(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.release();
        finish();
    }
}



