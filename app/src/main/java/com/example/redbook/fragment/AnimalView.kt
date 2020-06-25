package com.example.redbook.fragment

import com.example.redbook.data.model.Animal

interface AnimalView {
    fun setData(models: List<Animal>)
}