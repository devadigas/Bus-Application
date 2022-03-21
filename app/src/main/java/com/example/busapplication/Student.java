package com.example.busapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Student extends AppCompatActivity {

    Button b3;
    EditText e1,e2;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b3 = findViewById(R.id.b3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().equals("Student") && e2.getText().toString().equals("12345"))
                {
                    progressDialog = new ProgressDialog(Student.this);
                    progressDialog.setMessage("Loading..."); // Setting Message
                    progressDialog.setTitle("Login Activity"); // Setting Title
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                    progressDialog.show(); // Display Progress Dialog
                    progressDialog.setCancelable(false);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(30000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                        }
                    }).start();

                    Toast.makeText(Student.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(Student.this,stop.class);
                    startActivity(i2);
                }
                else
                {
                    Toast.makeText(Student.this, "You entered wrong credentials!!", Toast.LENGTH_SHORT).show();
                }

                if(e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty())
                {
                    Toast.makeText(Student.this, "Field cannot be Empty!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
