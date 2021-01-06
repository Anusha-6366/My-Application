package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Yesn extends AppCompatActivity {
    ImageView image;
    TextView text;
    String[] sectors = { "NO", "YES","NO", "YES","NO", "YES","NO", "YES","NO", "YES","NO","YES" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yesn);
        image=findViewById(R.id.image);
        text=findViewById(R.id.text);
        Collections.reverse(Arrays.asList(sectors));

    }


    public void spin(View view) {
        Random rr = new Random();
        final int degree = rr.nextInt(360);
        RotateAnimation rotateAnimation = new RotateAnimation(0, degree + 720,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(4000);
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
        image.startAnimation(rotateAnimation);
    }
    public void CalculatePoint(int degree){
        int initialPoint=0;
        int endPoint=30;
        int i=0;
        String res=null;
        do{
            if(degree>initialPoint && degree<endPoint) {
                res = sectors[i];
            }
            initialPoint +=30; endPoint +=30;
            i++;

        }while( res==null);
        text.setText(res);
    }

}


