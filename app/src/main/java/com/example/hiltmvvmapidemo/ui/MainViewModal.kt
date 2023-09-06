package com.example.hiltmvvmapidemo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltmvvmapidemo.model.Movie
import com.example.hiltmvvmapidemo.model.MovieDetailDto
import com.example.hiltmvvmapidemo.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModal @Inject constructor( private  val repository: RetroRepository) :ViewModel() {

    lateinit var  _movieList:MutableLiveData<List<Movie>>
    init {
        _movieList= MutableLiveData()
    }

    fun getMovieObserve():MutableLiveData<List<Movie>>{
        return _movieList
    }

    fun loadListMovie(){
        viewModelScope.launch {
            repository.apiCall(_movieList)
        }

    }

}