package com.balius.joke.model.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    companion object{

        fun createRetrofit(): ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://v2.jokeapi.dev/joke/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }

    }
}