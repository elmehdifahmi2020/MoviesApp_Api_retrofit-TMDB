package com.example.app__movies.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parceler

@Parcelize
data class Movie(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("title")
    val title : String?,

    @SerializedName("poster_path")
    val poster : String?,

    @SerializedName("overview")
    val overview : String?,
    @SerializedName("release_date")
    val release_date :String,
    @SerializedName("vote_average")
    val vote_average :String

) : Parcelable{
    constructor() : this("", "", "", "","","")


}