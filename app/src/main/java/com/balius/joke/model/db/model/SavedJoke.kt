package com.balius.joke.model.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="joke")
 class SavedJoke (

    @ColumnInfo(name = "joke") val Joke: String,

    ) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}