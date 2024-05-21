package com.example.app__movies.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app__movies.MovieViewModel
import com.example.app__movies.R

class MainActivity : AppCompatActivity() {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var rv: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    companion object{
        val MV_Id ="MV_ID"
        val MV_TITLE  ="MV_TITLE"
        val MV_POSTER  ="MV_POSTER"
        val overview ="overview"
        val release_date="release_date"
        val vote_average="vote_average"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieAdapter = MovieAdapter()
        rv = findViewById(R.id.rv)
        rv.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rv.setHasFixedSize(true)
        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        movieViewModel.getMovieData()
        observerMoviesLiveData()
        ClickOnRecyclerView()

    }

    private fun ClickOnRecyclerView() {
        movieAdapter.onItemClick = {movie->
            //Toast.makeText(applicationContext,movie.title.toString(), Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext, DetailsMovies::class.java)
            intent.putExtra(MV_Id,movie.id)
            intent.putExtra(MV_TITLE,movie.title)
            intent.putExtra(MV_POSTER,movie.poster)
            intent.putExtra(overview,movie.overview)
            intent.putExtra(release_date,movie.release_date)
            intent.putExtra(vote_average,movie.vote_average)
            startActivity(intent)

        }
    }


    private fun observerMoviesLiveData() {
        movieViewModel.observerMoviesLiveData().observe(this) { movies ->
            movieAdapter.setMovies(movies)
            rv.adapter = movieAdapter
        }
    }
}


