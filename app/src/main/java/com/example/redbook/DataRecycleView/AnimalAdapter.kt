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

class AnimalAdapter(private val listener: AnimalItemClickListener): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    var item: List<Animal> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
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

            itemView.setOnClickListener {
                listener.onAnimalItemClick(animal.id)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item, parent, false)
        return  AnimalViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return  item.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
    holder.popMod(item[position])
    }
}