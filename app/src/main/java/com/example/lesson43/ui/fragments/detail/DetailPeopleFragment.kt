package com.example.lesson43.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson43.Either
import com.example.lesson43.R
import com.example.lesson43.base.BaseFragment
import com.example.lesson43.databinding.FragmentDetailPeopleBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailPeopleFragment :
    BaseFragment<DetailViewModel, FragmentDetailPeopleBinding>(R.layout.fragment_detail_people) {

    override val binding by viewBinding(FragmentDetailPeopleBinding::bind)
    override val viewModel: DetailViewModel by viewModels()
    private val args by navArgs<DetailPeopleFragmentArgs>()

    override fun setupSubscribes() {
        viewModel.fetchPeopleId(args.position).observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("ilgiz", it.value)
                }
                is Either.Right -> {
                    Log.e("ilgiz2", it.toString())
                    binding.itemDetailPeopleName.text = it.value.name
                    binding.itemDetailPeopleGender.text = it.value.gender
                    binding.itemDetailPeopleAge.text = it.value.id
                }
            }
        }
    }
}