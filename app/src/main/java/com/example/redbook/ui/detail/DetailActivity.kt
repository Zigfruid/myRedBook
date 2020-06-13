package com.example.redbook.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redbook.R
import com.example.redbook.data.RedBookDataBase
import com.example.redbook.data.dao.AnimalDao
import com.example.redbook.data.model.Animal
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val ANIMAL_ID = "AnimalId"
    }
    private var animalId: Int = 0
    private lateinit var currentAnimal: Animal
    private  lateinit var dao: AnimalDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        animalId = intent.getIntExtra(ANIMAL_ID, 0)
        currentAnimal = dao.getAnimalById(animalId)

        tvStatusInfo.text = currentAnimal.status
        tvPropagationInfo.text = currentAnimal.propagation
        tvHabitatInfo.text = currentAnimal.habitat
        tvQuantityInfo.text = currentAnimal.quantity
        tvLifestyleInfo.text = currentAnimal.lifestyle
        tvLimitingFactorsInfo.text = currentAnimal.limitingFactors
        tvBreedingInfo.text = currentAnimal.breeding
        tvSecurityInfo.text = currentAnimal.security
    }
}