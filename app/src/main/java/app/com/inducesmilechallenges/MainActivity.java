package app.com.inducesmilechallenges;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.com.inducesmilechallenges.dayOneChallenge.DayOneFirstActivity;
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
            case R.id.button :
                Intent i1 = new Intent(MainActivity.this, DayOneFirstActivity.class);
                startActivity(i1);
                break;
            case R.id.button2 :
                Intent i2 = new Intent(MainActivity.this, DayTwoFirstActivity.class);
                startActivity(i2);
                break;
        }
    }

}
