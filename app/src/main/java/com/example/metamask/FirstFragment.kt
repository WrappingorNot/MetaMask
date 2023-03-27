package com.example.metamask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.metamask.databinding.ActivityFirstFragmentBinding

class FirstFragment : Fragment() {

    private lateinit var binding: ActivityFirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityFirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}
