package com.develop.sary.network

import com.develop.sary.responses.HomeCatalogResponse
import com.develop.sary.responses.HomeSliderResponse
import com.develop.sary.utility.Constants
import retrofit2.http.GET

interface HomeApi {

    @GET(Constants.Url.banners)
    suspend fun homeSlider(): HomeSliderResponse

    @GET(Constants.Url.catalog)
    suspend fun homeCatalog(): HomeCatalogResponse

}