package com.example.myapplication19.data

import com.example.myapplication19.data.ApiConstants.BASE_URL
import com.example.myapplication19.data.Entity.TmdbResults
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TmdbApi {
    @Headers( "X-API-KEY: 04bfc43f-167c-4cbc-b307-af88f19bb393")
    @GET(BASE_URL)
    fun getFilms(
        @Query("type") type : String,
        @Query("page") page: Int

    ): Call<TmdbResults>

    @Headers( "X-API-KEY: 04bfc43f-167c-4cbc-b307-af88f19bb393")
    @GET(BASE_URL)
    fun getFilmFromSearch(
        @Query("type") type : String,
        @Query("page") page: Int,
        @Query("query") query: String

    ): Observable<TmdbResults>
}