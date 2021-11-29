package com.example.vize201813709026;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler hnd=new Handler();
        hnd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent git=new Intent(MainActivity.this, kisiler.class);
                startActivity(git);

            }
        } , 2000);
    }
}