package com.emreakcadag.architecturecomponents.base.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.emreakcadag.architecturecomponents.feature.main.presentation.MainActivity

/**
 * Created by Emre Akçadağ on 11.06.2020
 */
class Navigator {

    private fun Context?.openActivity(intent: Intent?, requestCode: RequestCode? = null) = this?.takeIf { intent != null }?.run {
        requestCode?.let { (this as? Activity)?.startActivityForResult(intent, it.type) }
            ?: startActivity(intent)
    }

    fun openMainActivity(context: Context?) {
        context?.openActivity(MainActivity.newIntent(context))
    }
}