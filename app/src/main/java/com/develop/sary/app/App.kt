package com.develop.sary.app

import android.app.Application
import android.content.Context
import android.graphics.Typeface
import com.develop.sary.BuildConfig
import com.develop.sary.di.component.AppComponent
import com.develop.sary.di.component.DaggerAppComponent
import com.develop.sary.di.module.AndroidModule
import com.develop.sary.di.module.ApplicationModule
import timber.log.Timber
import java.lang.reflect.Field


class App : Application() {

    init {
        instance = this
    }

    companion object {
        var instance: App? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        createComponent()

        setDefaultFont("helvetica.ttf", "helvetica.ttf")
        instance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }

    protected open fun createComponent() {
        component =
            DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .androidModule(AndroidModule()).build()
    }

    private fun setDefaultFont(fontName: String, fontNameBold: String) {

        val bold = Typeface.createFromAsset(assets, fontNameBold)
        val italic = Typeface.createFromAsset(assets, fontName)
        val boldItalic = Typeface.createFromAsset(assets, fontNameBold)
        val regular = Typeface.createFromAsset(assets, fontName)

        val DEFAULT: Field
        try {
            DEFAULT = Typeface::class.java.getDeclaredField("DEFAULT")
            DEFAULT.isAccessible = true
            DEFAULT.set(null, regular)
        } catch (e: Exception) {
            Timber.e(e)
        }

        val DEFAULT_BOLD: Field
        try {
            DEFAULT_BOLD = Typeface::class.java.getDeclaredField("DEFAULT_BOLD")
            DEFAULT_BOLD.isAccessible = true
            DEFAULT_BOLD.set(null, bold)
        } catch (e: java.lang.Exception) {
            Timber.e(e)
        }

        val sDefaults: Field
        try {
            sDefaults = Typeface::class.java.getDeclaredField("sDefaults")
            sDefaults.isAccessible = true
            sDefaults.set(null, arrayOf(regular, bold, italic, boldItalic))
        } catch (e: java.lang.Exception) {
            Timber.e(e)
        }

        val monoField: Field
        try {
            monoField = Typeface::class.java.getDeclaredField("MONOSPACE")
            monoField.isAccessible = true
            monoField.set(null, regular)
        } catch (e: NoSuchFieldException) {
            Timber.e(e)
        }

        val SERIF: Field
        try {
            SERIF = Typeface::class.java.getDeclaredField("SERIF")
            SERIF.isAccessible = true
            SERIF.set(null, regular)
        } catch (e: Exception) {
            Timber.e(e)
        }

        val SANS_SERIF: Field
        try {
            SANS_SERIF = Typeface::class.java.getDeclaredField("SANS_SERIF")
            SANS_SERIF.isAccessible = true
            SANS_SERIF.set(null, regular)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }


}