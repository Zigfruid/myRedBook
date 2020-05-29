package com.example.redbook.DataRecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redbook.R

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    var item: List<DataFromBase> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }


    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun popMod(data: DataFromBase) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return  MainViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.recycle_item, parent, false))
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
       holder.popMod(item[position])
    }


}