package com.example.metamask.adapters

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.metamask.MainActivity
import com.example.metamask.R
import com.example.metamask.databinding.NetworkDialogBinding
import com.example.metamask.dataclasses.Dataclass
import com.example.metamask.dataclasses.netData
import java.util.LongSummaryStatistics
import kotlin.coroutines.coroutineContext

class CustomDialog(context: Context) : DialogFragment() {

    //private lateinit var binding: NetworkDialogBinding
    private val dialog = Dialog(context)



    fun myDig() {

        dialog.setContentView(R.layout.network_dialog)




        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
        )




        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)

        //리사이클러 뷰 사용

//        val recycle = view?.findViewById<RecyclerView>(R.id.network_recycle)
//        val itemlist = ArrayList<netData>()
//        Log.d("asd", "Roll1")
//
//        val adapter1 = ViewHolderNetwork(itemlist)
//        Log.d("asd", "Roll2")
//        if (recycle != null) {
//            adapter1.onAttachedToRecyclerView(recycle)
//        }
//        adapter1.notifyDataSetChanged()
//        recycle?.adapter = adapter1
//        Log.d("asd", "Roll3")
//        recycle?.layoutManager = LinearLayoutManager(dialog.context.applicationContext ,LinearLayoutManager.VERTICAL, false)



        dialog.show()
    }

}