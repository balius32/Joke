package com.balius.joke.model.repository.joke

interface JokeRepository {

    suspend fun getJoke() : String

    suspend fun  saveJoke(joke: String) : Boolean

}