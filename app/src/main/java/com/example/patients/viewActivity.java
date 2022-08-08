package com.example.patients;

import android.database.Cursor;
import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;



public class viewActivity extends AppCompatActivity implements View.OnClickListener{

    TextView DataView;
    DBHelper db = new DBHelper(this);
    Button buttonView;
    StringBuilder sb = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        DataView = findViewById(R.id.DataView);
        buttonView = findViewById(R.id.buttonView);
        buttonView.setOnClickListener(this);

        Cursor cursor = db.getdata();

        while (cursor.moveToNext()) {
            sb.append("PatientId:" + cursor.getString(0)+"\n");
            sb.append("Patient_Name:" + cursor.getString(1)+"\n");
            sb.append("PatientPhoneNumber:" + cursor.getString(2)+"\n");
            sb.append("PatientDisease :" + cursor.getString(3)+"\n\n");

        }

        DataView.setMovementMethod(new ScrollingMovementMethod());
    }


    @Override
    public void onClick(View view) {
        if(view.equals(buttonView))
            DataView.setText(sb);
    }
}
