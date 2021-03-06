package com.develop.sary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.develop.sary.network.RemoteDataSource
import com.develop.sary.repository.BaseRepository
import com.develop.sary.viewModel.ViewModelFactory

abstract class BaseActivity<VM : ViewModel, B : ViewDataBinding, R : BaseRepository> :
    AppCompatActivity() {

    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected val remoteDataSource = RemoteDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = getActivityBinding() as B

        val factory = ViewModelFactory(getActivityRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())

    }

    abstract fun getActivityBinding(): ViewDataBinding

    abstract fun getActivityRepository(): R

    abstract fun getViewModel(): Class<VM>

}