package com.example.lesson43.models

import com.google.gson.annotations.SerializedName

data class PeopleDetailModel(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("gender")
    val gender: String
)