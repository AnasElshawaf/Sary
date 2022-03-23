package com.develop.sary.repository

import com.develop.sary.network.HomeApi


class HomeRepository(private val api: HomeApi) : BaseRepository() {

    suspend fun homeSlider() = safeApiCall2 {
        api.homeSlider()
    }

    suspend fun homeCatalog() = safeApiCall {
        api.homeCatalog()
    }


}