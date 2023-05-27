package com.balius.joke.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.balius.joke.model.db.model.SavedJoke

@Dao
interface IDao {

    @Insert
    suspend fun insertJoke(savedJoke: SavedJoke) : Long



    @Query("Select * from joke")
    suspend fun getJoke() : List<SavedJoke>

    @Query("delete  from joke where joke= :joke")
    suspend fun deleteJoke(joke :String)
}