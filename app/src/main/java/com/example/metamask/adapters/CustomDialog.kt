package com.example.metamask.adapters

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import com.example.metamask.R

class CustomDialog(context: Context) {
    private val dialog = Dialog(context)

    fun myDig() {

        dialog.setContentView(R.layout.network_dialog)

        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)

        dialog.show()
    }
}