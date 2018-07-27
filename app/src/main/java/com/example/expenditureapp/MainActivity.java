package com.example.expenditureapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ExpenditureAdapter.expenditurelistOnclick {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    TextView tvDisplayExpenditure;
    private RecyclerView ExpenditureRecycleview;
    private  ExpenditureAdapter mAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //tvDisplayExpenditure = findViewById(R.id.textView);



        ExpenditureRecycleview = findViewById(R.id.expenditurelist);
        mAdapter = new ExpenditureAdapter(this,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ExpenditureRecycleview.setLayoutManager(layoutManager);
        ExpenditureRecycleview.setHasFixedSize(true);
        ExpenditureRecycleview.setAdapter(mAdapter);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startAddExpActivity = new Intent(MainActivity.this, AddExpActivity.class);
                startActivity(startAddExpActivity);
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
    public boolean onOptionsItemSelected(MenuItem item) {
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


    @Override
    protected void onResume() {
        super.onResume();
        List<Expenditure> expenditure = getDb().expenditureDao().selectAllExpenditurefromDb();
        Log.d(LOG_TAG, "The list has records: " + expenditure.size());

        mAdapter.setExpenditureList(expenditure);
    }

   public Appdata getDb(){
        String dataName = "Expenditure_db";
        Appdata db = Room.databaseBuilder(getApplicationContext(),Appdata.class,
                dataName).allowMainThreadQueries().build();
        return db;
    }


    @Override
    public void itemClicklistner(int itemId) {
        Intent takeMeToDetailsActivity = new Intent(this,ExpenditureDetails.class);
        takeMeToDetailsActivity.putExtra(Intent.EXTRA_TEXT,itemId);
        startActivity(takeMeToDetailsActivity);
    }
}