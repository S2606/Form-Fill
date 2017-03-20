package com.vcs.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener  {

    EditText name;
    EditText dob;
    EditText address;
    EditText phone;
    EditText emailid;
    Spinner occupation;
    RadioGroup radioGroup;
    RadioButton b1;
    RadioButton b2;
    MyDBHandler handler;
    String gender;
    int occuid;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        dob=(EditText)findViewById(R.id.d_o_b);
        address=(EditText)findViewById(R.id.address);
        phone=(EditText)findViewById(R.id.teleno);
        emailid=(EditText)findViewById(R.id.emailid);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        b1 = (RadioButton) findViewById(R.id.Maleid);
        b2 = (RadioButton) findViewById(R.id.Femaleid);
        b=(Button)findViewById(R.id.addbutton);
        handler=new MyDBHandler(getApplicationContext() );

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.Maleid)
                    gender = "MALE";
                else if (checkedId == R.id.Femaleid)
                    gender = "FEMALE";
            }
        });
        occupation=(Spinner)findViewById(R.id.spinner);
        occupation.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        List<String> categories = new ArrayList<String>();
        categories.add("salesman");
        categories.add("Businessman");
        categories.add("engineer");
        categories.add("Artist");
        categories.add("Teacher");
        categories.add("Chartered Accountant");
        categories.add("Comedian");
        categories.add("Sportsman");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        occupation.setAdapter(dataAdapter);



        //getActionBar().setTitle("Form");

    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        if (item=="salesman")
        {
            occuid=10;
        }
        else if(item=="Businessman")
        {
            occuid=20;
        }
        else if(item=="engineer")
        {
            occuid=30;
        }
        else if(item=="Artist")
        {
            occuid=40;
        }
        else if(item=="Teacher")
        {
            occuid=50;
        }
        else if(item=="Chartered Accountant")
        {
            occuid=60;
        }
        else if(item=="Comedian")
        {
            occuid=70;
        }
        else if(item=="Sportsman")
        {
            occuid=80;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //TODO  Auto-generated method stub
    }

    public void addButtonClicked(View view) {
       transfer t=new transfer(name.getText().toString(),dob.getText().toString(),address.getText().toString(),Integer.parseInt(phone.getText().toString()),
               emailid.getText().toString(),occuid);
        handler.addProduct(t);
        Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_LONG).show();
        name.setText("");
        dob.setText("");
        address.setText("");
        phone.setText("");
        emailid.setText("");
        b1.setChecked(false);
        b2.setChecked(false);
        occupation.setSelection(0);
    }

    public void back(View view)
    {
        Intent j=new Intent(this,LauncherActivity.class);
        startActivity(j);
    }
}
