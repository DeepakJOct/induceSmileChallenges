package app.com.inducesmilechallenges.dayEightChallenge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.com.inducesmilechallenges.R;

public class DayEightSecondActivity extends AppCompatActivity {

    TextView tvUsername;
    Button btnLogout;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_eight_second);
        tvUsername = findViewById(R.id.tv_username);
        btnLogout = findViewById(R.id.btn_logout);

        final String user = getIntent().getStringExtra("Username");

        if(!TextUtils.isEmpty(user)) {
            tvUsername.setText("Welcome..!" + "\n You are logged in with \n" + user);
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent = new Intent(DayEightSecondActivity.this, DayEightFirstActivity.class);
                startActivity(logoutIntent);
            }
        });
    }
}
