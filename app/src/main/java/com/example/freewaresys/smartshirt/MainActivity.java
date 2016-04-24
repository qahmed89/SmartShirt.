package com.example.freewaresys.smartshirt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBhelper helper =new DBhelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText a=(EditText)findViewById(R.id.TFusername);
      //  String ab =a.getText().toString();
        EditText s=(EditText)findViewById(R.id.TFpassword);
        String ab =s.getText().toString();
       Button b=(Button)findViewById(R.id.login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this
                        , Bluetooth.class);
                startActivityForResult(myIntent, 0);




            }
            }
        );
        TextView t =(TextView)findViewById(R.id.link_signup);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Signup.class);
                startActivityForResult(myIntent, 0);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


    }




        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }

