package com.example.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText UpdatePname, updatePhno, UpdateDisease;
    Button Updatingbtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        UpdatePname = findViewById(R.id.UpdatePname);
        updatePhno = findViewById(R.id.updatePhno);
        UpdateDisease = findViewById(R.id.UpdateDisease);

        db = new DBHelper(this);

        Updatingbtn = findViewById(R.id.Updatingbtn);
        Updatingbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String name = UpdatePname.getText().toString();
            String Phno = updatePhno.getText().toString();
            String issue = UpdateDisease.getText().toString();
            Patient p = new Patient();
            p.setName(name);
            p.setPatientPhone(Phno);
            p.setDisease(issue);
            db.updatedata(p);
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
        } catch (Exception E) {
            Toast.makeText(this, "Error in Updating Data", Toast.LENGTH_SHORT).show();
        }
    }
}