package com.example.expenditureapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ExpenditureDetails extends AppCompatActivity {

    TextView amountTotal;
    TextView itemName;
    TextView itemQuantity;
    TextView itemSubtotal;
    TextView itemStatus;
    TextView itemDate;
    TextView itemComment;
    int itemId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenditure_details2);
        amountTotal = findViewById(R.id.amountTotal);
        itemName = findViewById(R.id.itemName);
        itemQuantity= findViewById(R.id.itemQuantity);
        itemSubtotal = findViewById(R.id.itemSubtotal);
        itemStatus = findViewById(R.id.itemStatus);
        itemDate = findViewById(R.id.itemDate);
        itemComment = findViewById(R.id.itemComment);

        Intent intent = getIntent();
        if(intent !=null && intent.hasExtra(Intent.EXTRA_TEXT)){

            itemId = intent.getIntExtra(Intent.EXTRA_TEXT, -1);
            Expenditure expenditure = getDb() .expenditureDao().getSingleExpenditureByid(itemId);
            UpdateUI(expenditure);
        }


    }

    public void UpdateUI(Expenditure expenditure){
        amountTotal.setText(expenditure.getAmount());
        itemName .setText(expenditure.getItem());
        itemQuantity .setText(expenditure.getQuantity());
        itemStatus .setText(expenditure.getStatus());
        itemDate .setText(expenditure.getDate());
        itemComment.setText(expenditure.getComment());

    }

    private Appdata getDb() {
        String dataName = "Expenditure_db";
        Appdata db = Room.databaseBuilder(getApplicationContext(), Appdata.class,
                dataName).allowMainThreadQueries().build();
        return db;

    }
}
