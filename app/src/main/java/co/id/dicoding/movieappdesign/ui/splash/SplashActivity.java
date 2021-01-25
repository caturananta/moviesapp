package co.id.dicoding.movieappdesign.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import co.id.dicoding.movieappdesign.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    int splashTime = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();

            }
        }, splashTime);
    }
}
