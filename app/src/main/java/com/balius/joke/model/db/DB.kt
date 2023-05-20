package com.balius.joke.model.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.balius.joke.model.db.model.SavedJoke

@Database(entities = [SavedJoke::class], version = 1, exportSchema = false)
abstract class DB : RoomDatabase() {

    abstract fun dao() : IDao
}