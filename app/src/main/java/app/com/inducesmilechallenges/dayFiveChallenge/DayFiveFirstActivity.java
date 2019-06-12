package app.com.inducesmilechallenges.dayFiveChallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import app.com.inducesmilechallenges.R;

public class DayFiveFirstActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_five_first);

        radioGroup = findViewById(R.id.rg_dayfive);
        tvResult = findViewById(R.id.tv_result);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int radioButton) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio1:
                        tvResult.setText("First radio button is checked.");
                        break;
                    case R.id.radio2:
                        tvResult.setText("Second radio button is checked.");
                        break;
                    case R.id.radio3:
                        tvResult.setText("Third radio button is checked.");
                        break;
                    case R.id.radio4:
                        tvResult.setText("Fourth radio button is checked.");
                        break;
                }
            }
        });
    }
}
