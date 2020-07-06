package com.example.redbook.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbook.DataRecycleView.AnimalAdapter
import com.example.redbook.R
import com.example.redbook.data.RedBookDataBase
import com.example.redbook.data.dao.AnimalDao
import com.example.redbook.data.model.Animal
import com.example.redbook.ui.MainActivity
import com.example.redbook.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragement_rv1.*

class AnimalFragment : Fragment(R.layout.fragement_rv1){
    private val mAdapter = AnimalAdapter()
    private lateinit var dao: AnimalDao
    private lateinit var presenter: AnimalPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv1.adapter = mAdapter
        rv1.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        val type = arguments?.getInt(MainActivity.TYPE_ID) ?:1
        dao = RedBookDataBase.getInstance(requireContext()).dao()
        presenter = AnimalPresenter(dao)
        presenter.setFunctionBody {
            mAdapter.item = it
        }
        presenter.getAllAnimals(type)
        mAdapter.setOnItemClickListener {
            val mIntent = Intent(requireActivity(), DetailActivity::class.java)
            mIntent.putExtra(DetailActivity.ANIMAL_ID, it)
            startActivity(mIntent)
        }
        //search
         etSearch.addTextChangedListener {
            val result = dao.getAnimalByName(type, "${it.toString()}%")
                mAdapter.item = result
        }
    }

}