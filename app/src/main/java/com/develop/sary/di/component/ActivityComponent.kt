package com.develop.sary.di.component

import com.develop.sary.di.PerActivity
import com.develop.sary.di.module.ActivityModule
import dagger.Component

@PerActivity
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent
