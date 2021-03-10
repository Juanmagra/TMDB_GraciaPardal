package com.example.themoviedb_graciapardal.retrofit

import com.example.themoviedb_graciapardal.poko.ResponsePopular
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("popular?api_key=f5a6331c1b01f29a2da91d8c9a4779b4&language=en-US&page=1")
    fun getPeoplePopular(@Query("offset") paramOffset : String,
                       @Query("limit") paramLimit: String) : Call<ResponsePopular>

}