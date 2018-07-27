package com.example.expenditureapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ExpenditureDao {
    @Insert
    void insertExpenditure(Expenditure expenditure);

    @Query("SELECT * FROM expenditure")
    List<Expenditure> selectAllExpenditurefromDb();


    @Query("SELECT * FROM expenditure WHERE expid = :Expid")

    Expenditure getSingleExpenditureByid(int Expid);

    @Insert

    void inserSingleExpenditure(Expenditure expenditure);

    @Delete
    void deletExpenditure(Expenditure expenditure);

    @Update
    void UpdateExpenditure(Expenditure expenditure);




}
