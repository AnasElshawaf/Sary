package com.develop.sary.interfaces;

import com.develop.sary.responses.HomeSliderResponse

interface ClickListener {

    fun onSliderItemClick(
        item: HomeSliderResponse.Data?,
        position: Int
    );

}