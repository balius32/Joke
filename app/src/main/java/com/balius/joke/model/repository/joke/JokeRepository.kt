package com.balius.joke.model.repository.joke

import com.balius.joke.model.db.model.SavedJoke

interface JokeRepository {

    suspend fun getJoke() : String

    suspend fun  saveJoke(joke: String) : Boolean
    suspend fun  getSaveJoke() : List<SavedJoke>

    suspend fun  deleteJoke(joke : String) : Boolean


}