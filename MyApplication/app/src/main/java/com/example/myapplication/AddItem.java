package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class AddItem extends AppCompatActivity {

    Button pick_btn,done;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        done = findViewById(R.id.button3);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Inventory.class);

                intent.putExtra("Textbox",e1.getText().toString());
                intent.putExtra("Textbox1",e2.getText().toString());
                startActivity(intent);

            }
        });


    }


}
