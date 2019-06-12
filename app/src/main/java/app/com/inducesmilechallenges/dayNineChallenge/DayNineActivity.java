package app.com.inducesmilechallenges.dayNineChallenge;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import app.com.inducesmilechallenges.R;

public class DayNineActivity extends AppCompatActivity {

    TextView textView;
    Spinner spinner;
    SQLiteDatabase myDatabase;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_nine);

        textView = findViewById(R.id.tv_head);
        spinner = findViewById(R.id.spinner);

        mDatabaseHelper = new DatabaseHelper(this);
        mDatabaseHelper.insertData("Hyundai");
        mDatabaseHelper.insertData("Audi");
        mDatabaseHelper.insertData("Ford");
        mDatabaseHelper.insertData("Ferrari");
        mDatabaseHelper.insertData("Jaguar");
        mDatabaseHelper.insertData("Mercedes");

        String[] carBrands = getData();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, carBrands);
        spinner.setAdapter(adapter);


    }

    private String[] getData() {
        Cursor res = mDatabaseHelper.getAllData();
        String[] data = new String[res.getCount()];
        if (res.getCount() == 0) {
            //show message
            finish();
        } else {
                do {
                    for (int i = 0; i < res.getCount(); i++) {
                        data[i - 1] = res.getString(i);
                    }
                } while (res.moveToNext());
        }
        myDatabase.close();
        return data;
    }
}
