package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;


public class Inventory extends AppCompatActivity implements QuantityAdapter.ItemClickListener {


    static List<Quantity> quantityList=new ArrayList<>();
    RecyclerView recyclerView;
    QuantityAdapter adapter;
    Button btn;

    FirebaseAuth mAuth;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        mAuth = FirebaseAuth.getInstance();

       Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        String category=getIntent().getStringExtra("category");
        TextView textview1 = findViewById(R.id.textview1);
        btn = findViewById(R.id.add);
        textview1.setText("GROCERIES");




        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        LinearLayoutManager layoutmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutmanager);



        String name = getIntent().getStringExtra("Textbox");
        String val = getIntent().getStringExtra("Textbox1");
        //adding some items to our list
        quantityList.add(new Quantity(name,R.drawable.groceries , val));

        /*quantityList.add(new Quantity("onion", R.drawable.hm, String.valueOf(6)));
        quantityList.add(new Quantity("wheat", R.drawable.meetings, String.valueOf(7)));
        quantityList.add(new Quantity("rice", R.drawable.personaldetails, String.valueOf(8)));
        quantityList.add(new Quantity("sugar", R.drawable.miscellaneous, String.valueOf(9)));*/

        adapter = new QuantityAdapter(this, quantityList);

        adapter.setClickListener(this);

        //etting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                quantityList.remove(position);

            }
        });

        helper.attachToRecyclerView(recyclerView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddItem.class));

            }
        });
    }


    @Override
    public void onItemClick(View view, int position) {

        String text = quantityList.get(position).getText();
        String t = "Please note! The following item is added in your Inventory - "+ text;
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, t);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);

        //database query
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.search:
                startActivity(new Intent(this,Dashboard.class));
                break;

            case R.id.share:
                break;

            case R.id.notification:
                startActivity(new Intent(this,Reminder.class));
                break;

            case R.id.about:
                break;

            case R.id.logout:
                mAuth.signOut();
                Intent intent = new Intent(this, Title.class);
                startActivity(intent);
                break;

        }

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        /*if (mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, Title.class));
        }*/
    }

}

