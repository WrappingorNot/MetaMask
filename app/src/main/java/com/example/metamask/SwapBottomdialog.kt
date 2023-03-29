package com.example.metamask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.metamask.databinding.BottomDialogBinding
import com.example.metamask.databinding.BottomSwapBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SwapBottomdialog(): BottomSheetDialogFragment() {
    private lateinit var binding: BottomSwapBinding

    private lateinit var listAdapter: ArrayAdapter<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSwapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)




    }

}