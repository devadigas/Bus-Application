package com.example.busapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class stop extends AppCompatActivity {

    public FirebaseDatabase database;
    public DatabaseReference myRef;

    RadioButton r1,r2,r3,r4,r5;
    List<String> nameList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);

        myRef = FirebaseDatabase.getInstance().getReference().child("Stops");

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (r1.isChecked()) {
                    nameList.add((String) r1.getText());
                }
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (r2.isChecked()) {
                    nameList.add((String) r2.getText());
                }
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (r3.isChecked()) {
                    nameList.add((String) r3.getText());
                }
            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (r4.isChecked()) {
                    nameList.add((String) r4.getText());
                }
            }
        });
        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (r5.isChecked()) {
                    nameList.add((String) r5.getText());
                }
            }
        });

        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(r1.isChecked() || r2.isChecked() || r3.isChecked() || r4.isChecked() || r5.isChecked())) {
                    Toast.makeText(stop.this, "No response selected", Toast.LENGTH_LONG).show();
                }
                else
                {
                    for (int i = 0; i < nameList.size(); i++) {
                        myRef.setValue(nameList);
                    }
                    Toast.makeText(stop.this, "Data sent sucessfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent i5 = new Intent(stop.this,MainActivity.class);
        startActivity(i5);
    }
}
