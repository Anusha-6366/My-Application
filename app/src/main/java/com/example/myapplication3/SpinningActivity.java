package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class SpinningActivity extends AppCompatActivity {
ImageView spi2;
TextView textView;
String[] sectors={"1", "2","3", "4","5","6","7","8","9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinning);
        spi2=findViewById(R.id.spi2);
        textView = findViewById(R.id.textView);
        Collections.reverse(Arrays.asList(sectors));
    }

    public void SpinWheel(View view) {
        Random rr = new Random();
        int degree;
        degree = rr.nextInt(360);
        RotateAnimation rotateAnimation = new RotateAnimation(0, degree + 720,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(8000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CalculatePoint(degree);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        spi2.startAnimation(rotateAnimation);
    }
        public void CalculatePoint(int degree){
        int initialPOint=0;
        int endPoint=40;
        int i=0;
        String res=null;
        do {
            if (degree > initialPOint && degree < endPoint) res = sectors[i];
            initialPOint +=40;
            endPoint += 40;
            i++;
        }while (res==null);
        textView.setText(res);
    }
}