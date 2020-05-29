package com.example.redbook.fragment

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.redbook.DataRecycleView.DataFromBase
import com.example.redbook.DataRecycleView.MainAdapter
import com.example.redbook.R
import kotlinx.android.synthetic.main.fragement_rv1.*

open class FragmentWithRecycleView: Fragment(){

    private lateinit var rootView: View
    lateinit var recycleView: RecyclerView
    lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateComponent()
        fillData()
    }
        private fun onCreateComponent(){
            adapter = MainAdapter()
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragement_rv1, container, false)
        recycleView = rootView.findViewById(R.id.rv1)
        recycleView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        recycleView.layoutManager = LinearLayoutManager(activity)
        recycleView.adapter = adapter
        return  rootView
    }

    private fun fillData(){
        val massiv: MutableList<DataFromBase> = mutableListOf()
        for (i in 1..100){
            val item: DataFromBase = DataFromBase("name"," Dec", " ")
            massiv.add(item)

        }
        adapter.item = massiv
    }


}