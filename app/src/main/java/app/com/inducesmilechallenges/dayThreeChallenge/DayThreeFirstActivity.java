package app.com.inducesmilechallenges.dayThreeChallenge;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import app.com.inducesmilechallenges.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DayThreeFirstActivity extends AppCompatActivity {

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.textView)
    TextView textView;

    private String selectedCarBrand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_three_first);

        ButterKnife.bind(this);
        onButtonClick();

        String[] carsArray = getResources().getStringArray(R.array.names);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, carsArray) {
            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView,
                                        @NonNull ViewGroup parent) {

                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    return;
                }

                selectedCarBrand = adapterView.getItemAtPosition(position - 1).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @OnClick(R.id.button)
    void onButtonClick() {
        //TODO implement
        textView.setText("The selected car brand is " + selectedCarBrand.toUpperCase());
    }
}
