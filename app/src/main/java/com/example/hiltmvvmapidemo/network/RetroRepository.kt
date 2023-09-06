package com.example.hiltmvvmapidemo.network

import androidx.lifecycle.MutableLiveData
import com.example.hiltmvvmapidemo.model.Movie
import com.example.hiltmvvmapidemo.model.MovieDetailDto
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroServiceIntance: RetroServiceIntance) {

    suspend fun apiCall(livDataList : MutableLiveData<List<Movie>>){
        val res=retroServiceIntance.getPopularMovies()
        livDataList.postValue(res.results as List<Movie>?)
    }

//    suspend fun apiCall(): MovieDetailDto {
//        val res=retroServiceIntance.getPopularMovies()
//        return res
//    }
}