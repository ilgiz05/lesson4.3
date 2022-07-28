package com.example.lesson43.data.repositories

import com.example.lesson43.base.BaseRepository
import com.example.lesson43.data.apiservices.PeopleApiServices
import javax.inject.Inject

class PeopleRepository @Inject constructor(private val apiServices: PeopleApiServices) :
    BaseRepository() {

    fun fetchPeople() = doRequest { apiServices.fetchPeople() }

    fun fetchPeopleId(id: String) = doRequest { apiServices.fetchPeopleId(id) }
}

