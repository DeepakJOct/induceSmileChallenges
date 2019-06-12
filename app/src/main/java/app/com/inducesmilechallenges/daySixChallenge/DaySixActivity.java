package app.com.inducesmilechallenges.daySixChallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import app.com.inducesmilechallenges.R;

public class DaySixActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    Button btnSeeResult;
    TextView tvResult;
    ArrayList<String> selections;
    String mResult;
    private String mResult1, mResult2, mResult3, mResult4, mResult5, finalResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_six);


        checkBox1 = findViewById(R.id.checkBox2);
        checkBox2 = findViewById(R.id.checkBox3);
        checkBox3 = findViewById(R.id.checkBox4);
        checkBox4 = findViewById(R.id.checkBox5);
        checkBox5 = findViewById(R.id.checkBox6);
        tvResult = findViewById(R.id.tv_result);
        btnSeeResult = findViewById(R.id.btn_see_result);

        tvResult.setText("You have selected ");
        selections = new ArrayList<String>();

        checkBox1.setOnClickListener(this);
        checkBox2.setOnClickListener(this);
        checkBox3.setOnClickListener(this);
        checkBox4.setOnClickListener(this);
        checkBox5.setOnClickListener(this);

        btnSeeResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText(finalResult);
            }
        });


    }

    @Override
    public void onClick(View view) {

        boolean c1 = checkBox1.isChecked();
        boolean c2 = checkBox2.isChecked();
        boolean c3 = checkBox3.isChecked();
        boolean c4 = checkBox4.isChecked();
        boolean c5 = checkBox5.isChecked();

        mResult = null;
        if (c1) {
            mResult1 = "CheckBox1";
            if (!TextUtils.isEmpty(mResult)) {
                mResult = mResult + " and " + mResult1;
            } else {
                mResult = mResult1;
            }
        }

        if (c2) {
            mResult2 = "CheckBox2";
            if (!TextUtils.isEmpty(mResult)) {
                mResult = mResult + " and " + mResult2;
            } else {
                mResult = mResult2;
            }
        }

        if (c3) {
            mResult3 = "CheckBox3";
            if (!TextUtils.isEmpty(mResult)) {
                mResult = mResult + " and " + mResult3;
            } else {
                mResult = mResult3;
            }
        }

        if (c4) {
            mResult4 = "CheckBox4";
            if (!TextUtils.isEmpty(mResult)) {
                mResult = mResult + " and " + mResult4;
            } else {
                mResult = mResult4;
            }
        }

        if (c5) {
            mResult5 = "CheckBox5";
            if (!TextUtils.isEmpty(mResult)) {
                mResult = mResult + " and " + mResult5;
            } else {
                mResult = mResult5;
            }
        }


        if (!c1 && !c2 && !c3 & !c4 && !c5) {
            finalResult = "Select any checkbox";
        } else {
            finalResult = mResult + " selected";
        }
    }


}
