package com.example.watchflix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.watchflix.R
import com.example.watchflix.model.Movie

class MovieAdapter ( private val movies: List<Movie>, @LayoutRes private val layoutId: Int):
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)

    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie){
            val image: ImageView = itemView.findViewById(R.id.image_movie)
            //image.setImageResource(movie.coverUrl)  //movie.coverUrl

        }
    }

}