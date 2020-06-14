package com.emreakcadag.architecturecomponents.base

import android.app.AlertDialog
import com.emreakcadag.architecturecomponents.base.applicationlistener.ActivityRetriever
import com.emreakcadag.architecturecomponents.base.model.DialogBox
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Emre Akçadağ on 10.06.2020
 */
class DialogBoxHandler : KoinComponent {

    private val activityRetriever: ActivityRetriever by inject()

    fun showDialogBox(dialogBox: DialogBox?) {
        activityRetriever.activity?.runOnUiThread {
            val builder: AlertDialog.Builder? = activityRetriever.activity?.let {
                AlertDialog.Builder(it)
            }

            builder?.apply {
                setMessage(dialogBox?.description)
                setTitle(dialogBox?.title)

                setPositiveButton(dialogBox?.buttonList?.getOrNull(0)?.text) { dialog, _ ->
                    dialog.dismiss()
                }

                setNegativeButton(dialogBox?.buttonList?.getOrNull(1)?.text) { dialog, _ ->
                    dialog.cancel()
                }

                setCancelable(dialogBox?.isCancelable == true)
            }

            val dialog: AlertDialog? = builder?.create()
            dialog?.show()
        }
    }

    companion object {

        @Volatile
        private lateinit var INSTANCE: DialogBoxHandler

        val instance: DialogBoxHandler
            get() = if (::INSTANCE.isInitialized) INSTANCE else {
                INSTANCE = DialogBoxHandler()
                INSTANCE
            }
    }
}