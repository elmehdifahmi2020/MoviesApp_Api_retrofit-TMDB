package com.example.app__movies.retrofit

import com.example.app__movies.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    //@GET("/3/movie/popular?api_key=0217437351239d253c46f67c46f58bf7")
    @GET("/3/trending/movie/week?api_key=0217437351239d253c46f67c46f58bf7")
    //@GET("/3/trending/all/day?api_key=0217437351239d253c46f67c46f58bf7") all movies
    fun getMovieList(): Call<MovieResponse>
}