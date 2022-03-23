package com.develop.sary.view.dashboard.fragments.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.develop.sary.R
import com.develop.sary.databinding.FragmentHomeBinding
import com.develop.sary.interfaces.ClickListener
import com.develop.sary.network.HomeApi
import com.develop.sary.network.Resource
import com.develop.sary.repository.HomeRepository
import com.develop.sary.responses.HomeSliderResponse
import com.develop.sary.utility.handleApiError
import com.develop.sary.view.BaseFragment
import com.develop.sary.view.dashboard.fragments.home.adapter.ParentRecyclerAdapter
import com.develop.sary.view.dashboard.fragments.home.adapter.SliderRecyclerAdapter
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, HomeRepository>() {

    private lateinit var sliderAdapter: SliderRecyclerAdapter
    private lateinit var catalogAdapter: ParentRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getHomeData()

        initHomeAdapters()

        initCatalogRecyclerView()

        observeData()

    }

    private fun getHomeData() {
        viewModel.homeCatalog()
    }

    private fun observeData() {

        viewModel.homeSlider.observe(viewLifecycleOwner) {
            initSliderImages()
            hideShimmerRecyclerView()
        }

        viewModel.homeCatalog.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    viewModel.homeSlider()
                    catalogAdapter.setCatalogList(it.value.result)
                }

                is Resource.Failure -> {
                    handleApiError(it)
                }
            }
        }

    }

    private fun initCatalogRecyclerView() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvCatalog.layoutManager = layoutManager
        binding.rvCatalog.hasFixedSize()
        binding.rvCatalog.adapter = catalogAdapter
    }

    private fun initHomeAdapters() {
        sliderAdapter = SliderRecyclerAdapter(
            requireContext(), viewModel, object : ClickListener {
                override fun onSliderItemClick(
                    item: HomeSliderResponse.Data?,
                    position: Int
                ) {
                    Toast.makeText(context, item?.link, Toast.LENGTH_SHORT).show()
                }
            })

        catalogAdapter = ParentRecyclerAdapter(requireContext())
    }

    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewDataBinding {

        return DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

    }

    private fun initSliderImages() {
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        sliderView.indicatorSelectedColor = Color.WHITE
        sliderView.indicatorUnselectedColor = Color.GRAY
        sliderView.scrollTimeInSec = 3
        sliderView.startAutoCycle()
    }

    private fun hideShimmerRecyclerView() {
        ShimmerFrameLayout.visibility = View.GONE
        homeContainer.visibility = View.VISIBLE
    }

    override fun getFragmentRepository(): HomeRepository {

        return HomeRepository(remoteDataSource.buildApi(HomeApi::class.java))

    }

}