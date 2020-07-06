package com.example.redbook.fragment

import com.example.redbook.data.dao.AnimalDao
import com.example.redbook.data.model.Animal

class AnimalPresenter(private val dao: AnimalDao) {

    private var setData : (models:List<Animal>) -> Unit =  {
        println("ele islengen joq")
    }

    fun setFunctionBody(DataView :(a:List<Animal>) -> Unit){
        this.setData = DataView
    }


    fun getAllAnimals(type: Int){
        setData.invoke(dao.getAllAnimals(type))
    }
    fun getAnimalsFromFav(){
        setData.invoke(dao.getAnimalsFromFav())
    }
}