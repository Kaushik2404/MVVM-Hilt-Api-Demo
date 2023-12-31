package com.example.hiltmvvmapidemo.di

import com.example.hiltmvvmapidemo.network.RetroServiceIntance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val BASE_URL="http://api.themoviedb.org/"


    @Singleton
    @Provides
    fun getRetroInstance():Retrofit {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): RetroServiceIntance{
        return retrofit.create(RetroServiceIntance::class.java )
    }

}