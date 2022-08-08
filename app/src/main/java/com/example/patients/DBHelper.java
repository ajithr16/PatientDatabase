package com.example.patients;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "patient.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table PatientDetails(Id Text primary key, Patient_Name Text,Phone_number Text, Disease Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists PatientDetails");
    }

    public void insertdata(Patient patient) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("Id", patient.getId());
            cv.put("Patient_Name", patient.getName());
            cv.put("Phone_number", patient.getPatientPhone());
            cv.put("Disease", patient.getDisease());
            database.insert("PatientDetails", null, cv);
        } catch (Exception E) {

        }
    }

    public void updatedata(Patient patient) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("Phone_number", patient.getPatientPhone());
            cv.put("Disease", patient.getDisease());


            Cursor cursor = database.rawQuery("Select * from PatientDetails where Patient_Name = ?", new String[]{patient.getName()});
            if (cursor.getCount() > 0) {
                database.update("PatientDetails", cv, "Patient_Name=?", new String[]{patient.getName()});
            }
        } catch (Exception E) {

        }
    }

    public void deletedata(Patient patient) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();


            Cursor cursor = database.rawQuery("Select * from PatientDetails where Patient_Name = ?", new String[]{patient.getName()});
            if (cursor.getCount() > 0) {
                database.delete("PatientDetails", "Patient_Name=?", new String[]{patient.getName()});

            }
        } catch (Exception E) {

        }
    }

    public Cursor getdata() {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from PatientDetails", null);
        return cursor;

    }

    public Cursor searchdata(String Pname) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from PatientDetails where Patient_Name=?", new String[]{Pname});
        return cursor;
    }
}

