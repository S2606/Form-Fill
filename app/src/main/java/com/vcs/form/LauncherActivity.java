package com.vcs.form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Shagun on 04-Jul-16.
 */
public class LauncherActivity extends AppCompatActivity {

    Button ad;
    Button delete;
    Button Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        ad=(Button)findViewById(R.id.addingbutton);
        delete=(Button)findViewById(R.id.deletingbutton);
        Display=(Button)findViewById(R.id.displaybutton);

    }

    public void addingButtonClicked(View view)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void deletingbuttonClicked(View view)
    {
        Intent i=new Intent(this,DeleteActivity.class);
        startActivity(i);
    }

    public void displaybuttonClicked(View view)
    {
        Intent i=new Intent(this,DisplaylistActivity.class);
        startActivity(i);
    }


}
