package app.com.inducesmilechallenges.daySevenChallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import app.com.inducesmilechallenges.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DaySevenActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_seven);

    imageView = findViewById(R.id.iv_agera);
        button = findViewById(R.id.btn_submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView.getVisibility() == View.VISIBLE) {
                    imageView.setVisibility(View.INVISIBLE);
                    button.setText(R.string.show_image);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                    button.setText(R.string.hide_image);
                }


            }
        });

    }


}
