package com.balius.joke.model.webservice

import com.balius.joke.model.webservice.model.Joke
import retrofit2.http.GET

interface ApiService {

    @GET("Any?type=single")
    suspend fun getJoke() : Joke
}