package com.develop.sary.view.dashboard.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.develop.sary.databinding.ImageSliderLayoutItemBinding
import com.develop.sary.interfaces.ClickListener
import com.develop.sary.view.dashboard.ui.home.HomeViewModel
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderRecyclerAdapter(
    private val context: Context,
    private val mDeveloperModel: HomeViewModel,
    private val listener: ClickListener

) : SliderViewAdapter<SliderRecyclerAdapter.SliderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {

        val binding = ImageSliderLayoutItemBinding.inflate(LayoutInflater.from(context))

        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(mSliderViewHolder: SliderViewHolder, i: Int) {

        val currentStudent = mDeveloperModel.homeSlider.value?.result?.get(i)

        mSliderViewHolder.mSliderListItemBinding.sliderView.setOnClickListener {
            listener.onSliderItemClick(currentStudent, i)
        }

        mSliderViewHolder.mSliderListItemBinding.model = currentStudent

    }

    inner class SliderViewHolder(var mSliderListItemBinding: ImageSliderLayoutItemBinding) :
        SliderViewAdapter.ViewHolder(mSliderListItemBinding.root)

    override fun getCount(): Int {
        return if (mDeveloperModel.homeSlider.value?.result == null)
            0
        else mDeveloperModel.homeSlider.value?.result!!.size
    }

}