package com.balius.joke.ui.main

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.balius.joke.R
import com.balius.joke.databinding.ActivityMainBinding
import com.balius.joke.ui.save.SavedActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    private var isIcon1Visible: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.joke.observe(this) {

            binding.txtJoke.setText(it)
        }

        viewModel.saveJoke.observe(this) {
            if (it) {
                Toast.makeText(this, "save success", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "save success", Toast.LENGTH_LONG).show()
            }
        }

        setIcon()


        binding.btnSave.setOnClickListener {

            if (binding.txtJoke.text.toString() != "first time click the button !!") {
                if (isIcon1Visible) {
                    viewModel.saveJoke(binding.txtJoke.text.toString())
                    isIcon1Visible = !isIcon1Visible
                    setIcon()
                } else {
                    viewModel.deleteJoke(binding.txtJoke.text.toString())
                    isIcon1Visible = !isIcon1Visible
                    setIcon()
                }
            }

        }

        binding.btnJoke.setOnClickListener {
            binding.btnSave.setImageResource(R.drawable.baseline_bookmark_border_24)
            viewModel.getJoke()
        }


        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawer,
            binding.toolbar,
            R.string.nav_open,
            R.string.nav_close
        )

        toggle.isDrawerIndicatorEnabled = true
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()


        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_saved -> {
                    val intent: Intent = Intent(applicationContext, SavedActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
            }
            true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun setIcon() {
        if (isIcon1Visible) {
            binding.btnSave.setImageResource(R.drawable.baseline_bookmark_border_24)
        } else {
            binding.btnSave.setImageResource(R.drawable.baseline_bookmark_24)
        }
    }


}