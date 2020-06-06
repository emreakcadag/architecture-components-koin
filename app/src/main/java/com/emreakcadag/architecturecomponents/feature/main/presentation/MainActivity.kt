package com.emreakcadag.architecturecomponents.feature.main.presentation

import android.os.Bundle
import android.widget.Toast
import com.emreakcadag.architecturecomponents.R
import com.emreakcadag.architecturecomponents.base.BaseActivity
import com.emreakcadag.architecturecomponents.base.extension.observeLiveData
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.sendRequest()
        observeViewModel()
    }

    private fun observeViewModel() {
        observeLiveData(viewModel.responseLiveData) {
            Toast.makeText(this, it.url, Toast.LENGTH_LONG).show()
        }
    }

    override fun provideViewModel() = getViewModel<MainViewModel>()
}