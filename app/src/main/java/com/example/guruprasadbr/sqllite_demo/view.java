package com.example.guruprasadbr.sqllite_demo;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        String sql="select * from std order by usn";
        Cursor res=MainActivity.mydb.execQuery(sql);
        TableLayout tl=(TableLayout)findViewById(R.id.table_layout);
        TableRow tr[]=new TableRow[res.getCount()];
        TextView tv;
        int i=0;
        if(res!=null)
        {
            res.moveToFirst();
            while (!res.isAfterLast()) {
                tr[i] = new TableRow(this);
                tr[i].setPadding(10,0,10,0);
                for(int j=0;j<3;j++) {
                    tv = new TextView(this);
                    tv.setText(res.getString(j));
                    tv.setVisibility(View.VISIBLE);
                    tv.setMinHeight(10);
                    tv.setMinWidth(20);
                    tv.setTextColor(Color.BLACK);
                    tv.setTextSize(15);
                    tr[i].setMinimumHeight(tv.getMinHeight() + 5);
                    tr[i].setMinimumWidth((tv.getMinWidth()+2)*3);
                    tr[i].setVisibility(View.VISIBLE);
                    tr[i].addView(tv);
                }
                tl.addView(tr[i]);
                i++;
                res.moveToNext();
            }
        }
    }
}
