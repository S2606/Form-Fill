package com.vcs.form;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Shagun on 05-Jul-16.
 */
public class DeleteActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner s;
    TextView T;
    Button d;
    Button b;
    MyDBHandler dbHandler;
    int ans;
    AlertDialog.Builder alert;

    /*static class MyObject {
        String description;
        String value;

        public MyObject(String description, String value) {
            this.description = description;
            this.value = value;
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deleterecords);
        s = (Spinner) findViewById(R.id.spinner);
        T = (TextView) findViewById(R.id.details);
        d = (Button) findViewById(R.id.delbutton);
        b = (Button) findViewById(R.id.backbutton);
        alert = new AlertDialog.Builder(this);
        s.setOnItemSelectedListener(this);
        dbHandler = new MyDBHandler(getApplicationContext());
        List<String> lables = dbHandler.getalldata();
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        s.setAdapter(dataAdapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();
        String[] parts = item.split("_");
        String a = parts[0];
        if (a != null) {
            ans = Integer.parseInt(a);
            T.setText(dbHandler.getdata(ans));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //TODO Auto-generated method stub
    }

    public boolean deletebuttonClicked(View view) {
        alert.setTitle("Confirm Delete");
        // set dialog message
        alert
                .setMessage("Do you want to DELETE this entry?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        dbHandler.deleteValues(ans);
                        Toast.makeText(DeleteActivity.this, "Deleted", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), DeleteActivity.class);
                        startActivity(i);

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alert.create();

        // show it
        alertDialog.show();

        return true;
    }



    public void backbuttonClicked(View view)
    {
        Intent i=new Intent(this,LauncherActivity.class);
        startActivity(i);
    }

}
