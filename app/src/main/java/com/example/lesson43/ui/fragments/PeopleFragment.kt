package com.example.lesson43.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson43.Either
import com.example.lesson43.R
import com.example.lesson43.base.BaseFragment
import com.example.lesson43.databinding.FragmentPeopleBinding
import com.example.lesson43.ui.adapter.PeopleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment :
    BaseFragment<PeopleViewModel, FragmentPeopleBinding>(R.layout.fragment_people) {

    override val binding by viewBinding(FragmentPeopleBinding::bind)
    override val viewModel: PeopleViewModel by viewModels()
    private val peopleAdapter = PeopleAdapter(
        this::onItemClick
    )

    override fun initialize() {
        setupRecyclerview()
    }

    private fun setupRecyclerview() = with(binding.peopleRecyclerview) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = peopleAdapter
    }

    override fun setupSubscribes() {
        setupObserves()
    }

    private fun setupObserves() {
        viewModel.fetchPeople().observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("ilgiz", it.value)
                }
                is Either.Right -> {
                    Log.e("ilgiz2", it.toString())
                    peopleAdapter.submitList(it.value)
                }
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            PeopleFragmentDirections.actionPeopleFragmentToDetailPeopleFragment(
                position = id
            )
        )
    }
}
