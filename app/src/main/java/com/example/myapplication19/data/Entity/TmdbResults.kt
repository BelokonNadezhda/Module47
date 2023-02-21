package com.example.myapplication19.data.Entity

import com.google.gson.annotations.SerializedName

data class TmdbResults(
  @SerializedName("pagesCount")
  val pagesCount: Int,
  @SerializedName("films")
  val tmdbFilmItems: List<FilmItem>
)