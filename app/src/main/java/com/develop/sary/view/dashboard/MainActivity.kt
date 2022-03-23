package com.develop.sary.view.dashboard

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.develop.sary.R
import com.develop.sary.databinding.ActivityMainBinding
import com.develop.sary.network.HomeApi
import com.develop.sary.repository.HomeRepository
import com.develop.sary.view.BaseActivity
import com.develop.sary.view.dashboard.ui.home.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<HomeViewModel, ActivityMainBinding, HomeRepository>() {

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)

    }

    override fun getViewModel() = HomeViewModel::class.java

    override fun getActivityBinding(): ViewDataBinding {

        return DataBindingUtil.setContentView(this, R.layout.activity_main);

    }


    override fun getActivityRepository(): HomeRepository {

        return HomeRepository(remoteDataSource.buildApi(HomeApi::class.java))

    }

}