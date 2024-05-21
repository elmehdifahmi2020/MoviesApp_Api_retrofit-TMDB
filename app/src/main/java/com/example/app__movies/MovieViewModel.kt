package com.example.app__movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app__movies.model.Movie
import com.example.app__movies.model.MovieResponse
import com.example.app__movies.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private var MoviesLiveData = MutableLiveData<List<Movie>>()
    fun getMovieData() {
        RetrofitInstance.movieApi.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d( "HomeMovies",t.message.toString())
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
//                 MoviesLiveData.postValue(callback(response.body()!!.movies))
//                return callback(response.body()!!.movies)
                MoviesLiveData.value = response.body()!!.movies
            }


        })
    }
    fun observerMoviesLiveData(): LiveData<List<Movie>> {
        return MoviesLiveData
    }
}