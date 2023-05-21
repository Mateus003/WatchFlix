package com.example.watchflix

import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.watchflix.adapter.MovieAdapter
import com.example.watchflix.databinding.ActivityMovieBinding
import com.example.watchflix.model.Movie

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toDefineToolbar()


        val layerDrawable: LayerDrawable = ContextCompat.getDrawable(this, R.drawable.shadows) as LayerDrawable
        val movieCover = ContextCompat.getDrawable(this, R.drawable.movie_2)

        layerDrawable.setDrawableByLayerId(R.id.cover_drawable, movieCover)

        val coverImg = binding.movieImg
       // coverImg.setImageDrawable(layerDrawable)



        val movieTitle = binding.titleMovie

        val movieDesc = binding.movieDescription

        val castMovie = binding.castMovie


        initRecyclerView()

    }

    private fun toDefineToolbar(){
        val toolbar = binding.toolbarMovie

        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = null

    }

    private fun initRecyclerView(){


        val rv = binding.rvSimilarMovies

        rv.layoutManager = GridLayoutManager(this, 3)

        val movieList = mutableListOf<Movie>()
        //List Horizontal
        for (i in 1..9){
            val movie = Movie(R.drawable.movie)
            movieList.add(movie)
        }


        val adapter = MovieAdapter(movieList, R.layout.movie_item_similar)


        rv.adapter = adapter
    }
}