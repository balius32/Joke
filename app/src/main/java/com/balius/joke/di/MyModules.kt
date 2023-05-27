package com.balius.joke.di

import androidx.room.Room
import com.balius.joke.model.db.DB
import com.balius.joke.model.repository.joke.JokeRepository
import com.balius.joke.model.repository.joke.JokeRepositoryImpl
import com.balius.joke.model.webservice.Retrofit
import com.balius.joke.ui.main.MainViewModel
import com.balius.joke.ui.save.SavedViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MyModules = module{

    single { Room.databaseBuilder(androidContext(),DB::class.java,"joke.db").build() }
    single { Retrofit.createRetrofit() }

    single <JokeRepository>{ JokeRepositoryImpl(get(),get()) }


    viewModel{MainViewModel(get())}
    viewModel{SavedViewModel(get())}
}