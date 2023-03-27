package com.example.metamask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.metamask.databinding.ActivitySecondFragmentBinding

class SecondFragment : Fragment() {

    private lateinit var binding: ActivitySecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySecondFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}