package com.example.expenditureapp;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddExpActivity extends AppCompatActivity {
    int Expid;
     EditText edItem;
     EditText edQuantity;
     EditText edAmount;
     EditText edDate;
     EditText edComment;
     TextView estatus;


    String item;
    String quantity;
    String amount;
    String date;
    String comment;
    String status;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exp);

        edItem = findViewById(R.id.eItem);
        edQuantity = findViewById(R.id.eQuantity);
        edAmount = findViewById(R.id.eAmount);
        edDate = findViewById(R.id.eDate);
        edComment = findViewById(R.id.eComment);
        estatus = findViewById(R.id.estatus);


    }


    public void selectstatus(View radioButton){
        int idselected = radioButton.getId();
        if (idselected == R.id.btnCredit){
            status = "credit";
        }
        else  if(idselected == R.id.btnPaid){

            status = "paid";
        }

    }

    public void saveExpenditure(View SaveButton) {
        item = edItem.getText().toString();
        quantity = edQuantity.getText().toString();
        amount = edAmount.getText().toString();
        date = edDate.getText().toString();
        comment = edComment.getText().toString();




        if (!item.isEmpty() && !quantity.isEmpty() && !amount.isEmpty() && !date.isEmpty() && !comment.isEmpty()) {

             Expenditure newExpenditure = new Expenditure(item,quantity,amount,date,comment,status);

             Toast.makeText(this, "You typed in first Expenditure:" + newExpenditure.getComment() + "and comment:" +
                    newExpenditure.getItem(), Toast.LENGTH_SHORT).show();

           getDb().expenditureDao().insertExpenditure(newExpenditure);

            android.content.Intent startAddExpActivity = new android.content.Intent(this, MainActivity.class);
            startActivity(startAddExpActivity);

        } else {
            Toast.makeText(this, "Enter each Expenditure", Toast.LENGTH_SHORT).show();

        }


    }

    private Appdata getDb() {
        String dataName = "Expenditure_db";
        Appdata db = Room.databaseBuilder(getApplicationContext(), Appdata.class,
                dataName).allowMainThreadQueries().build();
        return db;

     }
}




