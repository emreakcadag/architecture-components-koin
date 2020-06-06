package com.emreakcadag.architecturecomponents.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emreakcadag.architecturecomponents.base.extension.TAG
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
abstract class BaseActivity<VM: BaseViewModel>(contentView: Int) : AppCompatActivity(contentView) {

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = provideViewModel()
    }

    abstract fun provideViewModel(): VM
}