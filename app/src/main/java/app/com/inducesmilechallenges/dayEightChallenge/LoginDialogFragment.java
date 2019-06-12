package app.com.inducesmilechallenges.dayEightChallenge;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import app.com.inducesmilechallenges.R;

public class LoginDialogFragment extends DialogFragment {

    EditText etUsername, etPassword;
    Button btnLogin;
    String mEmail, mPassword, existingEmail, existingPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_login_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etUsername = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.et_password);
        btnLogin = view.findViewById(R.id.btn_login);

        //validations

        /*//validations
        if(TextUtils.isEmpty(etUsername.getText())) {
            etUsername.setError("Email must not be empty");
        } else if(!etUsername.getText().toString().contains("@")) {
            etUsername.setError("Please enter a valid email");
        } else {
            mEmail = etUsername.getText().toString();
        }

        if(TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError("Password must not be empty");
        } else if(etPassword.getText().toString().length() < 3) {
            etPassword.setError("Password must be at least 6 characters long");
        } else {
            mPassword = etPassword.getText().toString();
        }*/

        try{
            SharedPreferences prefs = Objects.requireNonNull(getActivity()).getSharedPreferences("My Prefs", 0);
            existingEmail = prefs.getString("Email", "");
            existingPassword = prefs.getString("Password", "");
        }catch(Exception e){
            e.printStackTrace();
        }

        Log.d("credentials-->", "Existing Email" + existingEmail + " Existing Pass" + existingPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(etUsername.getText()) || TextUtils.isEmpty(etPassword.getText())) {
                    Toast.makeText(getActivity(), "Please fill in the details", Toast.LENGTH_SHORT).show();
                } else {

                    if(!etUsername.getText().toString().contains("@")) {
                        etUsername.setError("Please enter a valid email");
                    } else {
                        mEmail = etUsername.getText().toString();
                    }

                    if(etPassword.getText().toString().length() < 3) {
                        etPassword.setError("Password must be at least 6 characters long");
                    } else {
                        mPassword = etPassword.getText().toString();
                    }

                }

                Log.d("credentials-->", "Entered Email= " + mEmail + " Entered Pass= " + mPassword );


                if(mEmail.equalsIgnoreCase(existingEmail) && mPassword.equalsIgnoreCase(existingPassword)) {
                    Intent i = new Intent(getActivity(), DayEightSecondActivity.class);
                    i.putExtra("Username", mEmail);
                    startActivity(i);
                } else {
                    Toast.makeText(getContext(), "Invalid Credentials. If statement failed.", Toast.LENGTH_SHORT).show();
                }

                getDialog().dismiss();
            }
        });
    }
}
