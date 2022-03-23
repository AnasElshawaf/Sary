package com.develop.sary.view.dashboard.fragments.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.develop.sary.R
import com.develop.sary.databinding.FragmentOrdersBinding
import com.develop.sary.network.HomeApi
import com.develop.sary.repository.HomeRepository
import com.develop.sary.view.BaseFragment
import com.develop.sary.view.dashboard.fragments.home.HomeViewModel

class OrdersFragment : BaseFragment<HomeViewModel, FragmentOrdersBinding, HomeRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewDataBinding {

        return DataBindingUtil.inflate(inflater, R.layout.fragment_orders, container, false);

    }

    override fun getFragmentRepository(): HomeRepository {
        return HomeRepository(remoteDataSource.buildApi(HomeApi::class.java))

    }


}