package com.midterm.android.lambton.c0734506_midterm_mad3125f2018;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        scheduleSplashScreen();
    }

    private void scheduleSplashScreen()
    {
        long splashScreenDuration = getSplashScreenDuration();
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run ()
            {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, splashScreenDuration);
    }

    private long getSplashScreenDuration() { return 4000L; }
}
