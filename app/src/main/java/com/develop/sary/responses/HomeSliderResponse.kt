package com.develop.sary.responses

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class HomeSliderResponse(
    var result: List<Data>,
    var status: String = ""
) {
    data class Data(
        val id: Int,
        val metadata: Metadata,
        val title: String,
        val description: String,
        val button_text: String,
        val expiry_status: Boolean,
        val created_at: String,
        val start_date: String,
        val expiry_date: String,
        val image: String,
        val photo: String,
        val promo_code: String,
        val priority: Int,
        val link: String,
        val level: String,
        val is_available: Boolean,
        val branches: List<String>,
        val cities: List<Int>
    )

    inner class Metadata {
        var title: String? = null
        var sub_title: String? = null
        var consumable_display: String? = null

    }

    companion object {
        @JvmStatic
        @BindingAdapter("slideImage")
        fun loadImage(view: ImageView, image: String) {
            Glide.with(view.context)
                .load(image)
                .into(view)
        }
    }
}