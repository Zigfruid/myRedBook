package com.example.redbook.DataRecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.redbook.R
import com.example.redbook.data.model.Animal
import com.example.redbook.fragment.AnimalItemClickListener
import kotlinx.android.synthetic.main.recycle_item.view.*

class FavoriteAdapter(private val listener: AnimalItemClickListener): RecyclerView.Adapter<FavoriteAdapter.FavViewHolder>() {

    var item: List<Animal> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item , parent, false)
        return FavViewHolder(itemView)
    }

    override fun getItemCount(): Int {
    return  item.size
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        holder.popMod(item[position])
    }

    inner class FavViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun popMod(animal: Animal){
            itemView.tvRus.text = animal.nameRus
            itemView.tvEng.text = animal.nameEng
            itemView.tvUzb.text = animal.nameUzb
            val imageResName = "picture${animal.id}"
            Glide
                .with(itemView)
                .load(itemView.context.resources
                    .getIdentifier(imageResName, "drawable", itemView.context.packageName))
                .into(itemView.ivAnimal)

        }

    }

}