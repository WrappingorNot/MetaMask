package com.example.metamask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metamask.adapters.ViewHolder
import com.example.metamask.databinding.ActivityFirstFragmentBinding
import com.example.metamask.dataclasses.Dataclass

class FirstFragment : Fragment() {

    private lateinit var binding: ActivityFirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityFirstFragmentBinding.inflate(inflater, container, false)


        //리사이클러 뷰 사용
        val recycle = binding.recyclerView
        val itemlist = ArrayList<Dataclass>()
        itemlist.add(Dataclass ("0 ETH","$0.00"))
        //어댑터 호출하여, 리사이클러뷰 새로고침및 생성
        val adapter = ViewHolder(itemlist)
        adapter.notifyDataSetChanged()
        recycle.adapter = adapter
        recycle.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
