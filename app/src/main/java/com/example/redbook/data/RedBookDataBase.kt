package com.example.redbook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.redbook.data.dao.AnimalDao
import com.example.redbook.data.model.Animal


@Database(entities = [Animal::class], version = 1)
abstract  class RedBookDataBase : RoomDatabase() {
    companion object{
        private lateinit var INSTANCE: RedBookDataBase

        fun getInstance(context: Context) : RedBookDataBase =
            Room.databaseBuilder(
                context,
                RedBookDataBase::class.java,
                "book-database.db"
            )
                .createFromAsset("book-database.db")
                .allowMainThreadQueries()
                .build()
    }


    abstract fun dao(): AnimalDao
}