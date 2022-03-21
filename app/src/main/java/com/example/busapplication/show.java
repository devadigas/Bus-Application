package com.example.busapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class show extends AppCompatActivity {

    Button b5,b6;
    TextView t10;
    private DatabaseReference dr;
    List<String> data = new ArrayList<String>();
    StringBuilder jokeStringBuilder = new StringBuilder();
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        t10 = findViewById(R.id.t10);

        dr= FirebaseDatabase.getInstance().getReference().child("Stops");
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dr.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                str = dataSnapshot1.getValue(String.class);
                                data.add(str);
                            }
                        for (String s : data) {
                            jokeStringBuilder.append(s + "\n");
                        }
                        t10.setText(jokeStringBuilder.toString());
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t10.setText(null);
                dr.setValue(null);
                data.clear();
                Intent i4 = new Intent(show.this,MainActivity.class);
                startActivity(i4);
            }
        });
    }
}
