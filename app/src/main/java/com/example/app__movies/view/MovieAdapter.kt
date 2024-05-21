package com.example.app__movies.view



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app__movies.R
import com.example.app__movies.model.Movie


class MovieAdapter() :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){


    private lateinit var  movies : List<Movie>
    lateinit var onItemClick: ((Movie)-> Unit)

    fun setMovies(movies : List<Movie>){
        this.movies= movies
        notifyDataSetChanged()
    }

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie : Movie){
            itemView.findViewById<TextView>(R.id.title).text = movie.title
            itemView.findViewById<TextView>(R.id.vote_average).text = movie.vote_average
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.findViewById(R.id.image))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.template_movies, parent, false)

        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
        holder.itemView.setOnClickListener {
            onItemClick.invoke(movies[position])
        }
    }
}