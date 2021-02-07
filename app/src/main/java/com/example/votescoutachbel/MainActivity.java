package com.example.votescoutachbel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;

public class MainActivity extends AppCompatActivity {
    PieView animatedPie;
    PieAngleAnimation animation;
    Intent intent;
    Handler handlers;
    int progress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animatedPie = (PieView) findViewById(R.id.pieView);
// Change the color fill of the bar representing the current percentage
        animatedPie.setPercentageBackgroundColor(getResources().getColor(R.color.red));

        animatedPie.setInnerBackgroundColor(getResources().getColor(R.color.white));

// Change the color of the text of the widget
        animatedPie.setTextColor(getResources().getColor(R.color.red));
        animation = new PieAngleAnimation(animatedPie);
        animation.setDuration(5000); //This is the duration of the animation in millis
        animatedPie.startAnimation(animation);
        pieProgress();
    }
    @SuppressLint("HandlerLeak")
    public void pieProgress() {
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                intent = new Intent(MainActivity.this, LoginLeader.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        handlers = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == 0) {
                    if (progress < 100) {
                        progress = progress+2;
                        animatedPie.setPercentage((float) progress);
                    }
                }
            }
        };
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                    handlers.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();}
}