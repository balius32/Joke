package com.balius.joke.ui.main

import android.annotation.SuppressLint
import android.graphics.drawable.StateListDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.balius.joke.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.joke.observe(this){

            binding.txtJoke.setText(it)
        }

        viewModel.saveJoke.observe(this){
            if (it){
                Toast.makeText(this,"save success",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"save success",Toast.LENGTH_LONG).show()
            }
        }

        binding.btnSave.setOnClickListener{
            viewModel.saveJoke(binding.txtJoke.text.toString())
        }

        binding.btnJoke.setOnClickListener{

            viewModel.getJoke()
        }


    }
}