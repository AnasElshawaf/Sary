package com.develop.sary.view.dashboard.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.sary.network.Resource
import com.develop.sary.repository.HomeRepository
import com.develop.sary.responses.HomeCatalogResponse
import com.develop.sary.responses.HomeSliderResponse
import kotlinx.coroutines.launch

class HomeViewModel(
    private var repository: HomeRepository
) : ViewModel() {

    //Home Catalogs
    private val _homeCatalogResponse: MutableLiveData<Resource<HomeCatalogResponse>> =
        MutableLiveData()

    val homeCatalog: LiveData<Resource<HomeCatalogResponse>>
        get() = _homeCatalogResponse

    fun homeCatalog() = viewModelScope.launch {
        _homeCatalogResponse.value = repository.homeCatalog()
    }


    //Home Slider
    fun homeSlider() = viewModelScope.launch {
        _homeSliderResponse.value = repository.homeSlider()
    }

    private val _homeSliderResponse: MutableLiveData<HomeSliderResponse> =
        MutableLiveData<HomeSliderResponse>().apply { value?.result = emptyList() }

    val homeSlider: LiveData<HomeSliderResponse> get() = _homeSliderResponse


}