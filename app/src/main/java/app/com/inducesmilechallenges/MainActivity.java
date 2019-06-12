package app.com.inducesmilechallenges;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.com.inducesmilechallenges.dayFiveChallenge.DayFiveFirstActivity;
import app.com.inducesmilechallenges.dayFourChallenge.DayFourFirstActivity;
import app.com.inducesmilechallenges.dayNineChallenge.DayNineActivity;
import app.com.inducesmilechallenges.dayOneChallenge.DayOneFirstActivity;
import app.com.inducesmilechallenges.daySixChallenge.DaySixActivity;
import app.com.inducesmilechallenges.dayThreeChallenge.DayThreeFirstActivity;
import app.com.inducesmilechallenges.dayTwoChallenge.DayTwoFirstActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonDayOne, buttonDayTwo, buttonDayThree, buttonDayFour, buttonDayFive, buttonDaySix,
            buttonDaySeven, buttonDayEight, buttonDayNine, buttonDayTen, buttonDayEleven, buttonDayTwelve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDayOne = findViewById(R.id.button);
        buttonDayTwo = findViewById(R.id.button2);
        buttonDayThree = findViewById(R.id.button3);
        buttonDayFour = findViewById(R.id.button4);
        buttonDayFive = findViewById(R.id.button9);
        buttonDaySix = findViewById(R.id.button10);
        buttonDaySeven = findViewById(R.id.button11);
        buttonDayEight = findViewById(R.id.button12);
        buttonDayNine = findViewById(R.id.button13);
        buttonDayTen = findViewById(R.id.button14);
        buttonDayEleven = findViewById(R.id.button15);
        buttonDayTwelve = findViewById(R.id.button16);

        buttonDayOne.setOnClickListener(this);
        buttonDayTwo.setOnClickListener(this);
        buttonDayThree.setOnClickListener(this);
        buttonDayFour.setOnClickListener(this);
        buttonDayFive.setOnClickListener(this);
        buttonDaySix.setOnClickListener(this);
        buttonDaySeven.setOnClickListener(this);
        buttonDayEight.setOnClickListener(this);
        buttonDayNine.setOnClickListener(this);
        buttonDayTen.setOnClickListener(this);
        buttonDayEleven.setOnClickListener(this);
        buttonDayTwelve.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent i1 = new Intent(MainActivity.this, DayOneFirstActivity.class);
                startActivity(i1);
                break;
            case R.id.button2:
                Intent i2 = new Intent(MainActivity.this, DayTwoFirstActivity.class);
                startActivity(i2);
                break;
            case R.id.button3:
                Intent i3 = new Intent(MainActivity.this, DayThreeFirstActivity.class);
                startActivity(i3);
                break;
            case R.id.button4:
                Intent i4 = new Intent(MainActivity.this, DayFourFirstActivity.class);
                startActivity(i4);
                break;
            case R.id.button9:
                Intent i5 = new Intent(MainActivity.this, DayFiveFirstActivity.class);
                startActivity(i5);
                break;
            case R.id.button10:
                Intent i6 = new Intent(MainActivity.this, DaySixActivity.class);
                startActivity(i6);
                break;
            case R.id.button11:
                Intent i7 = new Intent(MainActivity.this, DayNineActivity.class);
                startActivity(i7);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        buttonDayOne.setText("Day 1 Challenge - Random Numbers");
        buttonDayTwo.setText("Day 2 Challenge - Email Password");
        buttonDayThree.setText("Day 3 Challenge - Spinner Selection");
        buttonDayFour.setText("Day 4 Challenge - Seekbar");
        buttonDayFive.setText("Day 5 Challenge - RadioGroup");
        buttonDaySix.setText("Day 6 Challenge - Checkbox");
    }
}
