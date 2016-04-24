package com.example.freewaresys.smartshirt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Freeware Sys on 4/4/2016.
 */
public class Signup extends Activity{
    DBhelper helper = new DBhelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button bb=(Button)findViewById(R.id.button);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    EditText email = (EditText) findViewById(R.id.email);
                    EditText uname = (EditText) findViewById(R.id.usname2);
                    EditText pass1 = (EditText) findViewById(R.id.pass1);
                    EditText pass2 = (EditText) findViewById(R.id.pass2);
                    EditText case1 = (EditText) findViewById(R.id.case1);
                    Spinner doc = (Spinner) findViewById(R.id.spinner);

                    String docstr = doc.getSelectedItem().toString();
                    String emailstr = email.getText().toString();
                    String unamestr = uname.getText().toString();
                    String pass1str = pass1.getText().toString();
                    String pass2str = pass2.getText().toString();
                    String casestr = case1.getText().toString();

                    if (!pass1str.equals(pass2str)) {
                        //popup msg
                        Toast pass = Toast.makeText(Signup.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                        pass.show();
                    } else {
                        //insert the detailes in database
                        Contact c = new Contact();
                        c.setDoctorname(docstr);
                        c.setEmail(emailstr);
                        c.setUsername(unamestr);
                        c.setPassword(pass1str);
                        c.setCase_patient(casestr);

                        helper.insertContact(c);
                        Intent i=new Intent(Signup.this,MainActivity.class);

                }}
            }  );

            }  }


