package com.example.myapplication.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insertAll(EntityClass entityClass);

    @Query("SELECT * FROM myTable")
    List<EntityClass> getAllData();

    @Delete
    public void delete(EntityClass entityClass);

}

