package com.example.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class searchActivity extends AppCompatActivity implements View.OnClickListener {
    DBHelper db = new DBHelper(this);
    EditText searchname;
    Button buttonsearch;
    TextView searchview;
    StringBuffer sb = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchname = findViewById(R.id.searchName);
        buttonsearch = findViewById(R.id.searchingbtn);
        searchview = findViewById(R.id.viewsearch);
        buttonsearch.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view.equals(buttonsearch)) {

            Cursor cursor = db.searchdata(searchname.getText().toString());

            while (cursor.moveToNext()) {
                sb.append("PatientId:" + cursor.getString(0) + "\n");
                sb.append("Patient_Name:" + cursor.getString(1) + "\n");
                sb.append("PatientPhoneNumber:" + cursor.getString(2) + "\n");
                sb.append("PatientDisease :" + cursor.getString(3) + "\n\n");

            }
            searchview.setText(sb);
            Toast.makeText(this, "searched", Toast.LENGTH_SHORT).show();
            searchview.setMovementMethod(new ScrollingMovementMethod());
        }
    }
}