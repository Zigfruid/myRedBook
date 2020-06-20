package com.example.redbook.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.redbook.DataRecycleView.AnimalAdapter
import com.example.redbook.R
import com.example.redbook.data.RedBookDataBase
import com.example.redbook.data.dao.AnimalDao
import com.example.redbook.data.model.Animal
import com.example.redbook.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.favorite_rv2.*

class FavoriteAnimal : Fragment(R.layout.favorite_rv2) , AnimalItemClickListener {
    private val favAdapter = AnimalAdapter(this)
    private lateinit var animalDao: AnimalDao
    private var models: List<Animal> = listOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fav_rv2.adapter = favAdapter
        fav_rv2.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        fav_rv2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        animalDao = RedBookDataBase.getInstance(requireContext()).dao()
        fillData()
        if (favAdapter.item.isEmpty()){
            fav_rv2.visibility = View.GONE
            tvPusto.visibility = View.VISIBLE
            ivIconVisible.visibility = View.VISIBLE
        }else {
            fav_rv2.visibility = View.VISIBLE
            tvPusto.visibility = View.GONE
            ivIconVisible.visibility = View.GONE
        }
    }
    private fun fillData(){
        favAdapter.item = animalDao.getAnimalsFromFav()

    }

    override fun onAnimalItemClick(id: Int) {
        val mIntent = Intent(requireActivity(), DetailActivity::class.java)
        mIntent.putExtra(DetailActivity.ANIMAL_ID, id)
        startActivity(mIntent)
    }

}