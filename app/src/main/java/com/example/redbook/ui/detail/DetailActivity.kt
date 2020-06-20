package com.example.redbook.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu?.findItem(R.id.item_bookmark)
        setFavoriteIcon()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> finish()
            R.id.item_bookmark -> setFavorite()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavorite(){
       if(currentAnimal.isFavorite == null) {
           currentAnimal.isFavorite = 1
           Toast.makeText(
               this,
               "${currentAnimal.nameRus} было добавлено в Избранные",
               Toast.LENGTH_SHORT
           ).show()
       }else currentAnimal.isFavorite = 1 - currentAnimal.isFavorite!!
        Toast.makeText(this, "${currentAnimal.nameRus} было удалено с Избранных", Toast.LENGTH_SHORT).show()
        setFavoriteIcon()
        dao.updateAnimal(currentAnimal)
    }
    private fun setFavoriteIcon(){
        if (currentAnimal.isFavorite == 1){
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_already)
        } else {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark)


        }
    }
}