package com.balius.joke.ui.save

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.balius.joke.adapter.JokeAdapter
import com.balius.joke.databinding.ActivitySavedBinding
import com.balius.joke.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedActivity : AppCompatActivity(), JokeAdapter.ActionListener {
    lateinit var binding : ActivitySavedBinding

    private val viewModel: SavedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.getJoke()

        viewModel.saveList.observe(this) {
            val adapter: JokeAdapter =
                JokeAdapter(applicationContext, it,this)
            binding?.recycle?.adapter = adapter
            binding?.recycle?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        }


        viewModel.isDeleted.observe(this){
            if (it){
                viewModel.getJoke()
            }else{
                Toast.makeText(applicationContext,"errore",Toast.LENGTH_SHORT)
            }
        }


        binding.imgBack.setOnClickListener{
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDeleteJoke(joke: String) {
        viewModel.deleteJoke(joke)
    }
}