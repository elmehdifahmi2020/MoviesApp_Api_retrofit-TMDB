package com.example.app__movies.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.app__movies.MovieViewModel
import com.example.app__movies.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.progressindicator.LinearProgressIndicator

class DetailsMovies : AppCompatActivity() {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    private lateinit var imgeView: ImageView
    private lateinit var titleMV: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movies)

        getData()
    }


    fun getData() {
        val imgdetails = findViewById<ImageView>(R.id.img_details)
        val title=findViewById<TextView>(R.id.titletxt)
        val overview =findViewById<TextView>(R.id.overview)
        val release_date=findViewById<TextView>(R.id.release_date)

        title.text = intent.getStringExtra(MainActivity.MV_TITLE)
        overview.text=intent.getStringExtra(MainActivity.overview)
        release_date.text=intent.getStringExtra(MainActivity.release_date)

        val poster = intent.getStringExtra(MainActivity.MV_POSTER)
        Glide.with(this).load(IMAGE_BASE + poster).into(imgdetails)



    }
}