package com.example.myapplication19.utils

import com.example.myapplication19.Film
import com.example.myapplication19.data.Entity.FilmItem

object Converter {
    fun convertApiListToDTOList(list: List<FilmItem>?): List<Film> {
        val result = mutableListOf<Film>()

        list?.forEach {
            result.add(Film(
                title = it.nameRu,
                //idfilm = it.filmId,
                poster = it.posterUrl,
                description = it.nameRu,
                rating = it.rating.toDouble(),
                isInFavorites = false
            ))
        }
        return result
    }
}