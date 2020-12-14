package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class Profile1 extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    String uid;
    String user_name,ph;
    TextView t1,t2,t3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);
        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();

        t3 = findViewById(R.id.textView10);
        t3.setText(user.getEmail());
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(fAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,Title.class));
        }
    }
}
