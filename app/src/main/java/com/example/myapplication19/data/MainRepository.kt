package com.example.myapplication19.data

import com.example.myapplication19.Film
import com.example.myapplication19.data.dao.FilmDao
import io.reactivex.rxjava3.core.Observable

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        //Запросы в БД должны быть в отдельном потоке
        //Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        //}
    }

   fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

}