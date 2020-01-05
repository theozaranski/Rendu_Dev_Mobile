package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class Reqres(
    @SerializedName("articles")
    val articles: List<Data>
)