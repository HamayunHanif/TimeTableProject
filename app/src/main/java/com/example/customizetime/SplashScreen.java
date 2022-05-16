package com.example.customizetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private ImageView logo;
    private TextView slogan ,title1;

    Animation  topAnimation ,bottomAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        logo = findViewById(R.id.logo);
        slogan = findViewById(R.id.slogan);
        title1 = findViewById(R.id.title1);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        logo.setAnimation(topAnimation);
        title1.setAnimation(bottomAnimation);
        slogan.setAnimation(bottomAnimation);

        int SPLASH_SCREEN = 4300;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in7 = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(in7);
                finish();
            }
        },SPLASH_SCREEN);



    }
}