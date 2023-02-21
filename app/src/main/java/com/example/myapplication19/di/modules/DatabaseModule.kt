package com.example.myapplication19.di.modules

import android.content.Context
import androidx.room.Room
import com.example.myapplication19.data.AppDatabase
import com.example.myapplication19.data.DatabaseHelper
import com.example.myapplication19.data.MainRepository
import com.example.myapplication19.data.dao.FilmDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "film_db"
        ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}