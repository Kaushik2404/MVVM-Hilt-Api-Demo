package com.example.hiltmvvmapidemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hiltmvvmapidemo.R
import com.example.hiltmvvmapidemo.ui.MainViewModal
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//     private var mainViewModal : MainViewModal by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModal= ViewModelProvider(this)[MainViewModal::class.java]

            viewModal.loadListMovie()

            viewModal.getMovieObserve().observe(this, Observer {

                 if (it != null) {
                     Log.d("MainActivity",it.toString())
                  }else{
                        Log.d("MainActivity","not data get api....")
                 }

        })
    }
}