package com.example.guruprasadbr.sqllite_demo;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import static android.content.Context.*;

/**
 * Created by Guruprasad BR on 6/15/2018.
 */
class db_oper {
    public static SQLiteDatabase db=null;
    Activity activity;
    public db_oper(Activity activity){
        this.activity=activity;
        SQLiteDatabase.CursorFactory cursorFactory=null;
        try {
            db = activity.openOrCreateDatabase("student_info", activity.MODE_PRIVATE, null);
            db.execSQL("create table if not exists std(" +
                    "USN varchar(15) primary key," +
                    "name varchar(20) not null," +
                    "mob integer" +
                    ")");
            Toast.makeText(activity,"Connection sucess",Toast.LENGTH_LONG).show();
        }
        catch (SQLiteException e){
            Log.d("Error: ",e.getMessage());
            Toast.makeText(activity,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    public String exec(String sql)
    {
        Log.d("Status: ","exec");
        if(!db.isOpen()) return "db_closed";
        try {
            db.execSQL(sql);
            Log.d("Status: ", "exec sucess");
            return "sucess";
        }
        catch (SQLiteException e) {
            Log.d("Error: ", e.getMessage());
            return sql+": "+e.getMessage();
        }
    }
    Cursor execQuery(String sql)
    {
        try {
            return db.rawQuery(sql,null);
        }
        catch (SQLiteException e) {
            Log.d("Error: ", e.getMessage());
            return null;
        }
    }
    public void close_db(){
        Toast.makeText(activity, "Disconnecting DB", Toast.LENGTH_LONG).show();
        if(db.isOpen()) {
            db.close();

            Log.d("Status: ", "DB closed");
        }
    }
}
