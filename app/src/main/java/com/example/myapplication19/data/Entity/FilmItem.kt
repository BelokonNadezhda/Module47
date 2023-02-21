package com.example.myapplication19.data.Entity

data class FilmItem(
    val countries: List<Country>,
    val filmId: Int,
    val filmLength: Any,
    val genres: List<Genre>,
    val nameEn: Any,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val rating: String,
    val ratingChange: Any,
    val ratingVoteCount: Int,
    val year: String
)