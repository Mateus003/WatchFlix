package com.example.watchflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.watchflix.adapter.CategoryAdapter
import com.example.watchflix.databinding.ActivityMainBinding
import com.example.watchflix.model.Category
import com.example.watchflix.model.Movie

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView(){

        val categories = mutableListOf<Category>(


        )
        //List Vertical
        for (j in 1..5){
            val movieList = mutableListOf<Movie>()
            //List Horizontal
            for (i in 1..5){
                val movie = Movie(R.drawable.movie)
                movieList.add(movie)
            }

            val category = Category("Categoria $j", movieList )
            categories.add(category)
        }




        val adapter = CategoryAdapter(categories)
        val rv: RecyclerView = binding.rvMain
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

    }

}