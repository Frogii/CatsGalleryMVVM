package com.example.mymvvm2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymvvm2.R
import com.example.mymvvm2.network.model.CatItem
import kotlinx.android.synthetic.main.item_cat.view.*

class CatAdapter(private val context: Context) : RecyclerView.Adapter<CatAdapter.ViewHolder>() {

    private var list: List<CatItem> = ArrayList()

    fun setCatList(list: List<CatItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.item_cat, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = list[position].id
        val cat = list[position]
        holder.bind(cat)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val id = v.cat_id
        fun bind(cat: CatItem) {
            Glide
                .with(itemView)
                .load(cat.url)
                .into(itemView.cat_image)
        }
    }
}