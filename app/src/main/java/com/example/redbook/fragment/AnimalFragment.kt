package com.example.redbook.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbook.DataRecycleView.AnimalAdapter
import com.example.redbook.R
import com.example.redbook.data.RedBookDataBase
import com.example.redbook.data.dao.AnimalDao
import kotlinx.android.synthetic.main.fragement_rv1.*

class AnimalFragment : Fragment(R.layout.fragement_rv1) {
    private val mAdapter = AnimalAdapter()
    private lateinit var dao: AnimalDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv1.adapter = mAdapter
        rv1.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        dao = RedBookDataBase.getInstance(requireContext()).dao()
        fillData()
    }

   private fun fillData(){
        mAdapter.item = dao.getAllAnimals()
    }
}