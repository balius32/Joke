package com.balius.joke.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.balius.joke.R
import com.balius.joke.model.db.model.SavedJoke


class JokeAdapter(
    private val context: Context,
    private val jokeList : List<SavedJoke>,
    private val actionListener: ActionListener
) : RecyclerView.Adapter<JokeAdapter.JokeVH>() {

    interface ActionListener{
        fun onDeleteJoke(joke : String)
    }



    class JokeVH (itemView: View): RecyclerView.ViewHolder(itemView){
        val txt_joke : AppCompatTextView = itemView.findViewById(R.id.txt_joke)
        val btn_delete : AppCompatImageView = itemView.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeVH {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.joke_row, parent, false)
        return JokeVH(view)
    }

    override fun getItemCount(): Int {
       return jokeList.size
    }

    override fun onBindViewHolder(holder: JokeVH, position: Int) {
      val savedJoke : SavedJoke = jokeList.get(position)

        holder.txt_joke.setText(savedJoke.Joke.toString())

        holder.btn_delete.setOnClickListener{
            actionListener.onDeleteJoke(savedJoke.Joke)
        }
    }

}