package com.develop.sary.di.module

import android.app.Activity
import android.content.Context
import com.develop.sary.di.ActivityContext
import com.develop.sary.di.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @PerActivity
    @Provides
    @ActivityContext
    fun provideContext(): Context = activity


}
