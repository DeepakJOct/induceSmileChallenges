package app.com.inducesmilechallenges.dayEightChallenge;

import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import app.com.inducesmilechallenges.R;

public class DayEightFirstActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin, btnSave;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_eight_first);

        etEmail = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnSave = findViewById(R.id.btn_save_details);
        btnLogin = findViewById(R.id.btn_login);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //validations

                if(TextUtils.isEmpty(etEmail.getText()) || TextUtils.isEmpty(etPassword.getText())) {
                    Toast.makeText(DayEightFirstActivity.this, "Please fill in the details", Toast.LENGTH_SHORT).show();
                } else {

                    if(!etEmail.getText().toString().contains("@")) {
                        etEmail.setError("Please enter a valid email");
                    } else {
                        email = etEmail.getText().toString();
                    }

                    if(etPassword.getText().toString().length() < 3) {
                        etPassword.setError("Password must be at least 6 characters long");
                    } else {
                        password = etPassword.getText().toString();
                    }

                    //Create SharedPreferences to store and get user data
                    SharedPreferences prefs = getApplicationContext().getSharedPreferences("My Prefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();

                    //Store the values of user into the prefs
                    if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                        editor.putString("Email", email);
                        editor.putString("Password", password);
                    }
                    editor.apply();

                    Log.d("credentials-->", prefs.getString("Email", "") + " " + prefs.getString("Password", ""));
                    Toast.makeText(DayEightFirstActivity.this, "Successfully saved the details", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
                if(prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                DialogFragment dialogFragment = new LoginDialogFragment();
                dialogFragment.show(ft, "dialog");
            }
        });



    }
}
