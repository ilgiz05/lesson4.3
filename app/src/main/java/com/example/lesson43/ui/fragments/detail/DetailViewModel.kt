package com.example.lesson43.ui.fragments.detail

import com.example.lesson43.base.BaseViewModel
import com.example.lesson43.data.repositories.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: PeopleRepository) :
    BaseViewModel() {

    fun fetchPeopleId(id: String) = repository.fetchPeopleId(id)
}