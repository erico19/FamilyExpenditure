package com.example.expenditureapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Expenditure {


    @ColumnInfo(name = "item")
    private String item;

    private  String quantity;

    private String amount;

    private String date;

    private  String comment;
    private  String status;


    @PrimaryKey(autoGenerate = true)
    private int Expid;


    public Expenditure(String item, String quantity, String amount, String date, String comment, String status, int Expid) {
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
        this.date = date;
        this.comment = comment;
        this.status = status;
        this.Expid = Expid;
    }



    @Ignore
    public Expenditure(String item, String quantity, String amount, String date, String comment,String status) {
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
        this.date = date;
        this.comment = comment;
        this.status = status;


    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getExpid() {
        return Expid;
    }

    public void setExpid(int Expid) {
        this.Expid = Expid;
    }





}
