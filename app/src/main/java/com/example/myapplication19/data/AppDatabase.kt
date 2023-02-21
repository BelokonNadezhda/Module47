package com.example.myapplication19.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication19.Film
import com.example.myapplication19.data.dao.FilmDao

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}