package app.com.inducesmilechallenges.dayTwoChallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.com.inducesmilechallenges.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DayTwoFirstActivity extends AppCompatActivity {

    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.et2)
    EditText et2;
    @BindView(R.id.btn_activity_a)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_two_activity_first);
        ButterKnife.bind(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(et1.getText()) || !TextUtils.isEmpty(et2.getText())) {
                    if (!et1.getText().toString().contains("@")) {
                        Toast.makeText(DayTwoFirstActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent i = new Intent(DayTwoFirstActivity.this, DayTwoSecondActivity.class);
                        i.putExtra("email", et1.getText().toString());
                        i.putExtra("password", et2.getText().toString());
                        startActivity(i);
                    }
                } else {
                    Toast.makeText(DayTwoFirstActivity.this, "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
