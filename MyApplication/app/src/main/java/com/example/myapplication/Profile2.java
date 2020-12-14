package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Profile2 extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    String uid;
    String user_name,ph;
    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();

        t3 = findViewById(R.id.textView101);
        t3.setText(user.getEmail());
    }
}
