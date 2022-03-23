package com.develop.sary.di.component

import com.develop.sary.di.module.ActivityModule
import com.develop.sary.di.module.AndroidModule
import com.develop.sary.di.module.ApplicationModule
import com.develop.sary.network.RemoteDataSource
import com.develop.sary.view.dashboard.MainActivity
import com.develop.sary.view.dashboard.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class,
        AndroidModule::class, ActivityModule::class]
)

interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(homeFragment: HomeFragment)

    fun inject(remoteDataSource: RemoteDataSource)

}