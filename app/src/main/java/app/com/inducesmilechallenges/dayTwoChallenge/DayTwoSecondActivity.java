package app.com.inducesmilechallenges.dayTwoChallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import app.com.inducesmilechallenges.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DayTwoSecondActivity extends AppCompatActivity {

    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_password)
    TextView tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_two_activity_second);

        ButterKnife.bind(this);

        tvEmail.setText("Email: " + getIntent().getStringExtra("email"));
        tvPassword.setText("Password: " + getIntent().getStringExtra("password"));

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
