package com.balius.joke.model.repository.joke

import com.balius.joke.model.db.DB
import com.balius.joke.model.db.model.SavedJoke
import com.balius.joke.model.webservice.ApiService
import com.balius.joke.model.webservice.model.Joke

class JokeRepositoryImpl(
    val apiService: ApiService,
    val db: DB
) : JokeRepository {


    override suspend fun getJoke(): String {
        try {
            val joke: Joke = apiService.getJoke()
            return joke.joke.toString()
        } catch (e: java.lang.Exception) {
            return "something went wrong ==> $e"
        }


    }


    override suspend fun saveJoke(joke: String): Boolean {
        val save: SavedJoke = SavedJoke(joke)
        val isAdded = db.dao().insertJoke(save)
        return isAdded != 0L

    }

    override suspend fun getSaveJoke(): List<SavedJoke>
    {
        val saveList : List<SavedJoke> = db.dao().getJoke()

        return saveList
    }

    override suspend fun deleteJoke(joke : String): Boolean {
      db.dao().deleteJoke(joke)
        return true
    }


}