package com.example.mysqlconeection

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = MyHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM ACBTABLE ", null);
        var  edname = findViewById<EditText>(R.id.edname)
        var edMeaning = findViewById<EditText>(R.id.edMeaning)
        var first = findViewById<Button>(R.id.first)
        var next = findViewById<Button>(R.id.next)
        var prèvies = findViewById<Button>(R.id.prev)

        first.setOnClickListener {

            if(rs.moveToFirst()){
                edname.setText(rs.getString(1))
                edMeaning.setText(rs.getString((2)))
            }
            else{
                Toast.makeText(applicationContext,"No Data Found",Toast.LENGTH_LONG).show();
            }
        }

        next.setOnClickListener {

            if(rs.moveToNext()){
                edname.setText(rs.getString(1))
                edMeaning.setText(rs.getString((2)))
            }
            else if(rs.moveToFirst()){
                edname.setText(rs.getString(1))
                edMeaning.setText(rs.getString((2)))
            }
            else {
                Toast.makeText(applicationContext,"No Data Found",Toast.LENGTH_LONG).show();
            }
        }

        prèvies.setOnClickListener {

            if(rs.moveToPrevious()){
                edname.setText(rs.getString(1))
                edMeaning.setText(rs.getString((2)))
            }
            else if(rs.moveToLast()){
                edname.setText(rs.getString(1))
                edMeaning.setText(rs.getString((2)))
            }
            else {
                Toast.makeText(applicationContext,"No Data Found",Toast.LENGTH_LONG).show();
            }

        }


    }
}