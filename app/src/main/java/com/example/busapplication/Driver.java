package com.example.busapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Driver extends AppCompatActivity {

    EditText e3,e4;
    Button b4;
    ProgressDialog progressDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        b4 = findViewById(R.id.b4);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(e3.getText().toString().isEmpty() || e4.getText().toString().isEmpty())
                {
                    Toast.makeText(Driver.this, "Field cannot be Empty!!", Toast.LENGTH_SHORT).show();
                }

                if(e3.getText().toString().equals("Bus") && e4.getText().toString().equals("54321"))
                {
                    progressDialog1 = new ProgressDialog(Driver.this);
                    progressDialog1.setMessage("Loading..."); // Setting Message
                    progressDialog1.setTitle("Login Activity"); // Setting Title
                    progressDialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                    progressDialog1.show(); // Display Progress Dialog
                    progressDialog1.setCancelable(false);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(30000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            progressDialog1.dismiss();
                        }
                    }).start();

                    Toast.makeText(Driver.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent i3 = new Intent(Driver.this,show.class);
                    startActivity(i3);
                }
                else
                {
                    Toast.makeText(Driver.this, "You entered wrong credentials!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
