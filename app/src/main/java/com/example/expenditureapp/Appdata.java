package com.example.expenditureapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Expenditure.class},version = 1)
public abstract class Appdata extends RoomDatabase{

    public abstract ExpenditureDao expenditureDao();


}