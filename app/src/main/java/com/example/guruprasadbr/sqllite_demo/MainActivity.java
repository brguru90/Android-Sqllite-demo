package com.example.guruprasadbr.sqllite_demo;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static db_oper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(db_oper.db==null)
            mydb=new db_oper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ins=(Button)findViewById(R.id.button);
        Button view=(Button)findViewById(R.id.button2);
        Button del=(Button)findViewById(R.id.button3);
        Button updt=(Button) findViewById(R.id.button4);
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insert=new Intent(MainActivity.this,insert.class);
                startActivity(insert);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view=new Intent(MainActivity.this,view.class);
                startActivity(view);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // setContentView(R.layout.delete);
            }
        });
        updt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.update);
            }
        });
    }
    public void onBackPressed() {

       // Log.d("Guru:","Bye");
        //Toast.makeText(this,"Bye",Toast.LENGTH_SHORT).show();
    }
    public void onDestroy(){
        super.onDestroy();
        mydb.close_db();
    }
}
