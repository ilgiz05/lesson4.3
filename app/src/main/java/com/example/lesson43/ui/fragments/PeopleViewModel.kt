package com.example.lesson43.ui.fragments

import com.example.lesson43.base.BaseViewModel
import com.example.lesson43.data.repositories.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(private val repository: PeopleRepository) : BaseViewModel() {

    fun fetchPeople() = repository.fetchPeople()
}