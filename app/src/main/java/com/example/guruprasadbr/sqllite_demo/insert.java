package com.example.guruprasadbr.sqllite_demo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class insert extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Button add=(Button)findViewById(R.id.button6);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.editText4);
                EditText usn = (EditText) findViewById(R.id.editText5);
                EditText mob = (EditText) findViewById(R.id.editText6);
                String sql = "insert into std values('" + usn.getEditableText().toString() + "','" + name.getEditableText().toString() + "','" + mob.getEditableText().toString() + "')";
                Toast.makeText(insert.this, "STATUS:" + MainActivity.mydb.exec(sql), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onBackPressed() {
        Toast.makeText(this, "Main activity", Toast.LENGTH_SHORT).show();
        Intent main=new Intent(insert.this,MainActivity.class);
        startActivity(main);
        // Log.d("Guru:","Bye");
    }
}
