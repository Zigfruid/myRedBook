package com.example.redbook.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbook.DataRecycleView.AnimalAdapter
import com.example.redbook.DataRecycleView.FavoriteAdapter
import com.example.redbook.R
import com.example.redbook.data.RedBookDataBase
import com.example.redbook.data.dao.AnimalDao
import com.example.redbook.data.model.Animal
import com.example.redbook.ui.MainActivity
import com.example.redbook.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.favorite_rv2.*

class FavoriteAnimal : Fragment(R.layout.favorite_rv2) , AnimalItemClickListener {

    private val favAdapter = AnimalAdapter(this)
    private lateinit var  dao: AnimalDao
   
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fav_rv2.adapter = favAdapter
        fav_rv2.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        val type = arguments?.getInt(MainActivity.TYPE_ID) ?:1
        dao = RedBookDataBase.getInstance(requireContext()).dao()
         favData(type)

    }

    private fun favData(type: Int){
        favAdapter.item = dao.getAllAnimals(type)
    }


    override fun onAnimalItemClick(id: Int) {
        val mIntent = Intent(requireActivity(),DetailActivity::class.java)
        mIntent.putExtra(MainActivity.TYPE_ID, id)
        startActivity(mIntent)
    }
}