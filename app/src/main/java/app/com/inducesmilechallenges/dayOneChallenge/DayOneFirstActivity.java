package app.com.inducesmilechallenges.dayOneChallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import app.com.inducesmilechallenges.R;

public class DayOneFirstActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_one_activity_first);

        textView = findViewById(R.id.tv_first_number);
        button = findViewById(R.id.btn_activity_a);
        randomGenerateNumber();

        int number = randomGenerateNumber();

        String randomNumber = Integer.toString(number);

        textView.setText(String.valueOf(number));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DayOneFirstActivity.this, DayOneSecondActivity.class);
                i.putExtra("Random Number", textView.getText());
                startActivity(i);
            }
        });
    }

    public int randomGenerateNumber() {
        Random rand = new Random();
        int A = rand.nextInt(50);
        A += A;
        return A;
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.setText(getIntent().getStringExtra("New Random Number"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
