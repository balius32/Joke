package com.balius.joke.model.db

import androidx.room.Dao
import androidx.room.Insert
import com.balius.joke.model.db.model.SavedJoke

@Dao
interface IDao {

    @Insert
    suspend fun insertJoke(savedJoke: SavedJoke) : Long
}