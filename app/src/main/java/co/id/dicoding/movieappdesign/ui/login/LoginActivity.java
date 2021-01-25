package co.id.dicoding.movieappdesign.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import co.id.dicoding.movieappdesign.R;
import co.id.dicoding.movieappdesign.ui.home.HomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBarWhite);
        setContentView(R.layout.activity_login);

        Button signinBtn = findViewById(R.id.signinButton);
        signinBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signinButton) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();

            Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(homeIntent);
        }
    }
}
