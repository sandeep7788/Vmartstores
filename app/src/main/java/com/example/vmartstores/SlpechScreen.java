package com.example.vmartstores;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlpechScreen extends AppCompatActivity {
    TextView f39t;
    TextView t1;
    String version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.f39t = (TextView) findViewById(R.id.txt);
        this.t1 = (TextView) findViewById(R.id.txt1);
        StartAnimations();

        Thread timer= new Thread()
        {
            public void run()
            {
                try
                {
                    //Display for 3 seconds
                    sleep(3000);
                }
                catch (InterruptedException e)
                {

                    e.printStackTrace();
                }
                finally
                {
                    //Goes to Activity  StartingPoint.java(STARTINGPOINT)
                    Intent myintent = new Intent(SlpechScreen.this, MainActivity.class);
                    startActivity(myintent);
                }
            }
        };
        timer.start();

      /*  new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent myintent = new Intent(SlpechScreen.this, MainActivity1.class);
                startActivity(myintent);
                finish();
            }
        }, 1000);*/

    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l = (RelativeLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.img);
        iv.clearAnimation();
        iv.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.a);
        anim.reset();
        this.f39t.clearAnimation();
        this.f39t.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.b);
        anim.reset();
        this.t1.clearAnimation();
        this.t1.startAnimation(anim);
    }
}