package com.example.redbook.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.redbook.R
import com.example.redbook.data.RedBookDataBase
import com.example.redbook.data.dao.AnimalDao
import com.example.redbook.data.model.Animal
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.recycle_item.view.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val ANIMAL_ID = "AnimalId"
    }
    private var animalId: Int = 0
    private lateinit var currentAnimal: Animal
    private  lateinit var dao : AnimalDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Details")

        dao = RedBookDataBase.getInstance(this).dao()
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

        Glide
                .with(this)
                .load(resources
                .getIdentifier("picture${animalId}", "drawable", packageName))
                .into(ivAnimalPicture)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}