package com.example.app__movies.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parceler

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies : List<Movie>

) : Parcelable {
    constructor() : this(mutableListOf())


}
