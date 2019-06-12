package app.com.inducesmilechallenges.dayFourChallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import app.com.inducesmilechallenges.R;

public class DayFourFirstActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_four_first);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBar.setMax(100);
                seekBar.animate();
                if(i >= 40 && i <= 45) {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("You have reached " + i + "%.");
                } else {
                    textView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
