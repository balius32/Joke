package com.balius.joke.ui.save

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balius.joke.model.db.model.SavedJoke
import com.balius.joke.model.repository.joke.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SavedViewModel(
    val jokeRepository: JokeRepository
) :ViewModel() {

    var isError = MutableLiveData<Boolean>()
    var isSaveError = MutableLiveData<Boolean>()

    private val _saveList= MutableLiveData<List<SavedJoke>>()
    val saveList: LiveData<List<SavedJoke>>
        get() = _saveList


    private var _isDeleted =  MutableLiveData<Boolean>()
    val isDeleted: LiveData<Boolean>
        get() = _isDeleted

    fun getJoke() {

        viewModelScope.launch {

            try {
                val result = withContext(Dispatchers.IO) {

                    val jokeList: List<SavedJoke> = jokeRepository.getSaveJoke()

                    jokeList
                }
                _saveList.value = result
                isError.value = false

            } catch (e: java.lang.Exception) {

                isError.value = true

            }
        }
    }

    fun deleteJoke(joke : String){

        viewModelScope.launch {
            try {

                val result = withContext(Dispatchers.IO){

                    val isDelted : Boolean = jokeRepository.deleteJoke(joke)

                    isDelted
                }
               _isDeleted.value = result

            }catch (e :Exception){
               Log.e("","")
            }
        }
    }


}