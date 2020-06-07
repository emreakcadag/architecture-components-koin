package com.emreakcadag.architecturecomponents.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(private val layoutResID: Int) : AppCompatActivity() {

    lateinit var viewModel: VM private set
    lateinit var binding: DB private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = provideViewModel()

        binding = DataBindingUtil.setContentView(this, layoutResID)
        bindViewModel(binding)
    }

    abstract fun provideViewModel(): VM

    abstract fun bindViewModel(binding: DB)
}