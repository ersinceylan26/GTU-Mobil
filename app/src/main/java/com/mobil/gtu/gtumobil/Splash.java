package com.mobil.gtu.gtumobil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toolbar;

public class Splash extends AppCompatActivity
{
    ImageView splahImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splahImage = (ImageView) findViewById(R.id.splashImage);

        Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        splahImage.startAnimation(myAnim);

        final Intent i = new Intent(this,MainActivity.class);

        Thread timer = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };

        timer.start();

    }
}
