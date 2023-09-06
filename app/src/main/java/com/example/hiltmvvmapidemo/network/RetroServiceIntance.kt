package com.example.hiltmvvmapidemo.network

import com.example.hiltmvvmapidemo.model.MovieDetailDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceIntance {


    @GET("3/discover/movie?sort_by=popularity.desc")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String? = "57a4269b6c0098d52f01d65572e57972"
    ): MovieDetailDto

}