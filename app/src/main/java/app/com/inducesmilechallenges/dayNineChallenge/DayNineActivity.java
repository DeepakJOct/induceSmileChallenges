package app.com.inducesmilechallenges.dayNineChallenge;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_nine);
        createDatabaseTable();

        textView = findViewById(R.id.tv_head);
        spinner = findViewById(R.id.spinner);

        String[] carBrands = getData();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, carBrands);
        spinner.setAdapter(adapter);



    }

    private String[] getData() {
        String tableName = "cars";
        String selectQuery = "SELECT * FROM " + tableName;
        Cursor res = myDatabase.rawQuery(selectQuery, null);
        String[] data = null;
        if(res.moveToFirst()) {
            do{
                for(int i = 0; i < res.getCount(); i++) {
                    data[i] = res.getString(i);
                }
            } while(res.moveToNext());
        }
        myDatabase.close();
        return data;
     }

    public void createDatabaseTable() {
        myDatabase = openOrCreateDatabase("CarBrands", MODE_PRIVATE, null);
        myDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS cars (\n" +
                        " id int NOT NULL,\n" +
                        " brand varchar(200) NOT NULL" + ");"
        );

        myDatabase.execSQL("INSERT INTO cars \n" +
                "(brand)\n" +
                "VALUES \n" +
                "('Mercedes');");
        myDatabase.execSQL("INSERT INTO cars \n" +
                "(brand)\n" +
                "VALUES \n" +
                "('Audi');");
        myDatabase.execSQL("INSERT INTO cars \n" +
                "(brand)\n" +
                "VALUES \n" +
                "('Ford');");
        myDatabase.execSQL("INSERT INTO cars \n" +
                "(brand)\n" +
                "VALUES \n" +
                "('Ferrari');");
        myDatabase.execSQL("INSERT INTO cars \n" +
                "(brand)\n" +
                "VALUES \n" +
                "(Chevrolet);");
        myDatabase.execSQL("INSERT INTO cars \n" +
                "(brand)\n" +
                "VALUES \n" +
                "('Bugatti');");
    }
}
