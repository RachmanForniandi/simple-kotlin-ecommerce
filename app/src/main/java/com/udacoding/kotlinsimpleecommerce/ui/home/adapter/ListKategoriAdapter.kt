package com.udacoding.kotlinsimpleecommerce.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udacoding.kotlinsimpleecommerce.Model.ListKategori.DataItem
import com.udacoding.kotlinsimpleecommerce.R
import com.udacoding.kotlinsimpleecommerce.Utils.Constan
import kotlinx.android.synthetic.main.item_kategori.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ListKategoriAdapter(private val mValues: List<DataItem>?, private val listener: onItemClickListener) :
    RecyclerView.Adapter<ListKategoriAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_kategori,
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun getItemCount(): Int = mValues?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues?.get(position)

        holder.mKategori.text = item?.kategori
        Glide.with(holder.mImage).load(Constan.IMAGE_URL + item?.gambar).into(holder.mImage)

        holder.view.onClick {
            listener.itemClick(item)
        }

    }


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val mImage = view.ivKategori
        val mKategori = view.tvKategori

    }

    interface onItemClickListener {
        fun itemClick(item: DataItem?)
    }
}