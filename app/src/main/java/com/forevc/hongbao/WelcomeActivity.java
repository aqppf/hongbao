package com.forevc.hongbao;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 1000);
    }

}
