package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null); //this line create database or open a already exist database

        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");
        myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Purvesh',19)");
        myDatabase.execSQL("INSERT INTO users(name,age) VALUES ('Pawan',19)");

        Cursor c = myDatabase.rawQuery("SELECT * FROM users",null);

        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");


        c.moveToFirst();

        // we want loop through each row inside of the table
        while (c != null){
            Log.i("name",c.getString(nameIndex));
            Log.i("age",c.getString(ageIndex));

            c.moveToNext();
        }
    }
}