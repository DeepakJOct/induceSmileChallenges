package app.com.inducesmilechallenges.dayNineChallenge;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import app.com.inducesmilechallenges.R;

public class DayNineActivity extends AppCompatActivity {

    TextView textView;
    Spinner spinner;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_nine);

        textView = findViewById(R.id.tv_head);
        spinner = findViewById(R.id.spinner);

        textView.setText("Fetching data into spinner from SQLite Database.");

        mDatabaseHelper = new DatabaseHelper(this);
        mDatabaseHelper.insertData("Hyundai");
        mDatabaseHelper.insertData("Audi");
        mDatabaseHelper.insertData("Ford");
        mDatabaseHelper.insertData("Ferrari");
        mDatabaseHelper.insertData("Jaguar");
        mDatabaseHelper.insertData("Mercedes");
        mDatabaseHelper.close();

//        String[] carBrands = getData();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getData());
        adapter.notifyDataSetChanged();
        spinner.setAdapter(adapter);


    }

    private String[] getData() {
        Cursor res = mDatabaseHelper.getAllData();
        Log.d("CursorResult--> ", res.toString());
        String[] data = new String[(res.getCount())];
        int i = 0;
        res.moveToFirst();
        while(!res.isAfterLast()) {
            data[i] = res.getString(1);
            i++;
            res.moveToNext();
        }
        res.close();
        return data;
    }
}
