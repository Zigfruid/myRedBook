package com.example.redbook.fragment

import com.example.redbook.data.dao.AnimalDao

class AnimalPresenter(private val dao: AnimalDao, private val view: AnimalView) {

    fun getAllAnimals(type: Int){
        view.setData(dao.getAllAnimals(type))
    }
    fun getAnimalsFromFav(){
        view.setData(dao.getAnimalsFromFav())
    }
}