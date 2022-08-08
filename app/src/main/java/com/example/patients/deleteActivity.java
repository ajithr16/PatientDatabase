package com.example.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class deleteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText deletePatient;
    Button Deletingbtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        deletePatient = findViewById(R.id.DeletePatient);
        Deletingbtn = findViewById(R.id.deletingbtn);

        db = new DBHelper(this);
        Deletingbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String name = deletePatient.getText().toString();
            Patient p = new Patient();
            p.setName(name);
            db.deletedata(p);
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show();
        } catch (Exception E) {
            Toast.makeText(this, "Error in Deleting Data", Toast.LENGTH_SHORT).show();
        }
    }
}