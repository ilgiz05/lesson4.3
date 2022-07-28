package com.example.lesson43.data.apiservices

import com.example.lesson43.models.PeopleDetailModel
import com.example.lesson43.models.PeopleModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleApiServices {

    @GET("people")
    suspend fun fetchPeople(): List<PeopleModel>

    @GET("people/{id}")
    suspend fun fetchPeopleId(
        @Path("id") id: String
    ): PeopleDetailModel
}
