package com.example.mysqlconeection

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context) : SQLiteOpenHelper(context,"ACDB",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ACBTABLE(_id integer primary key autoincrement, NAME TEXT, MEANING TEXT)")
        db?.execSQL("INSERT INTO ACBTABLE(NAME,MEANING) VALUES('WWW', 'World Wide Web')")
        db?.execSQL("INSERT INTO ACBTABLE(NAME,MEANING) VALUES('AVD', 'Android Virtual Machine')")
        db?.execSQL("INSERT INTO ACBTABLE(NAME,MEANING) VALUES('SQL', 'Structured Query Language')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

}