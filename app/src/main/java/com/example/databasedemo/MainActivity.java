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

      try {
          SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Thenewusers",MODE_PRIVATE,null);

          sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS thenewusers(name VARCHAR,age INT(4))");
          sqLiteDatabase.execSQL("INSERT INTO thenewusers (name,age) VALUES('pawan',18)");
          sqLiteDatabase.execSQL("INSERT INTO thenewusers (name,age) VALUES('pratik',21)");
          sqLiteDatabase.execSQL("INSERT INTO thenewusers (name,age) VALUES('pratik',21)");

          Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM thenewusers", null);

          int nameIndex = c.getColumnIndex("name");
          int ageIndex = c.getColumnIndex("age");
          int idIndex = c.getColumnIndex("id"); //get id automatically

          c.moveToFirst();
          while (c !=null){
              Log.i("UserResults - Name",c.getString(nameIndex));
              Log.i("UserResults - age",Integer.toString(c.getInt(ageIndex)));
              Log.i("UserResults - id",Integer.toString(c.getInt(idIndex))); //get id ---------

              c.moveToNext();
          }


      } catch (Exception e) {
          e.printStackTrace();
      }
    }
}