//package com.example.myapplication14;
package com.example.agronomistfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    ImageView imageView;
    private static int SPLASH_SCREEN_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_splash);
        ImageView imageView = findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        imageView.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Splash.this, MainActivity2.class);
                startActivity(intent);
                finish();
                //invoke the SecondActivity.


                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}