package com.emreakcadag.architecturecomponents.feature.main.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.emreakcadag.architecturecomponents.R
import com.emreakcadag.architecturecomponents.base.BaseActivity
import com.emreakcadag.architecturecomponents.base.extension.observeLiveData
import com.emreakcadag.architecturecomponents.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(R.layout.activity_main) {

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getMainResponseData()
        observeViewModel()
    }

    private fun observeViewModel() {
        observeLiveData(viewModel.responseLiveData) {}
    }

    override fun provideViewModel() = getViewModel<MainViewModel>()

    override fun bindViewModel(binding: ActivityMainBinding) {
        binding.viewModel = viewModel
    }
}