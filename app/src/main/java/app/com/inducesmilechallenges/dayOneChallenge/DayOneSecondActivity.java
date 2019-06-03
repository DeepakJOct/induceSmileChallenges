package app.com.inducesmilechallenges.dayOneChallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import app.com.inducesmilechallenges.R;

public class DayOneSecondActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_one_activity_second);

        textView = findViewById(R.id.tv_number);
        button = findViewById(R.id.btn_activity_b);

        final String newRandomNumber = Integer.toString(randomGenerateNumber());

        textView.setText(getIntent().getStringExtra("Random Number"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DayOneSecondActivity.this, DayOneFirstActivity.class);
                i.putExtra("New Random Number", newRandomNumber);
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
}
