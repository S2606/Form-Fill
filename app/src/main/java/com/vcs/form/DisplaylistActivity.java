package com.vcs.form;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Shagun on 06-Jul-16.
 */
public class DisplaylistActivity extends ListActivity {

    MyDBHandler db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayrecords);
        db=new MyDBHandler(getApplicationContext());
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.listfile,
                db.getAllTitles(),
                new String[] {"_name", "_dob", "_address", "_phno", "_emailid" },
                new int[] { R.id.text1 , R.id.text2, R.id.text3,  R.id.text4,  R.id.text5});

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);


    }
}
