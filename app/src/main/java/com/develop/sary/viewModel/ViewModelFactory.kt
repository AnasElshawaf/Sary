package com.develop.sary.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.develop.sary.repository.BaseRepository
import com.develop.sary.repository.HomeRepository
import com.develop.sary.view.dashboard.fragments.home.HomeViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: BaseRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return when {

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(
                repository as HomeRepository
            ) as T


            else -> throw IllegalArgumentException("ViewModel Not Found")
        }

    }


}