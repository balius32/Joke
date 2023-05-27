package com.balius.joke.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balius.joke.model.repository.joke.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val jokeRepository: JokeRepository
) : ViewModel() {

    var isError = MutableLiveData<Boolean>()
    var isSaveError = MutableLiveData<Boolean>()

    private val _joke = MutableLiveData<String>()
    val joke: LiveData<String>
        get() = _joke

    private val _saveJoke = MutableLiveData<Boolean>()
    val saveJoke: LiveData<Boolean>
        get() = _saveJoke

    fun getJoke() {

        viewModelScope.launch {

            try {
                val result = withContext(Dispatchers.IO) {

                    val joke: String = jokeRepository.getJoke()

                    joke
                }
                _joke.value = result
                isError.value = false

            } catch (e: java.lang.Exception) {

                isError.value = true

            }
        }
    }


    fun saveJoke(joke: String) {

        viewModelScope.launch {

            try {
                val result = withContext(Dispatchers.IO) {

                    val save: Boolean = jokeRepository.saveJoke(joke)

                    save
                }
                _saveJoke.value = result
                isSaveError.value = false

            } catch (e: java.lang.Exception) {

                isSaveError.value = true

            }
        }
    }


    fun deleteJoke(joke: String) {

        viewModelScope.launch {

            try {
                val result = withContext(Dispatchers.IO) {

                    jokeRepository.deleteJoke(joke)

                }

            } catch (e: java.lang.Exception) {

                Log.e("error", "delete joke error")
            }
        }
    }

}