package com.example.kotlinmovieapptry.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinmovieapptry.R
import com.example.kotlinmovieapptry.model.DataItem

class MovieAdapter(val context: Context, var prodlist: ArrayList<DataItem?>?):
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.prodnametv.text = prodlist?.get(position)?.title
        Glide.with(context).load(prodlist?.get(position)?.poster)
            .apply(RequestOptions().centerCrop())
            .into(holder.imageview)
    }


    override fun getItemCount(): Int {
        return prodlist!!.size
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val prodnametv: TextView = itemView!!.findViewById(R.id.tvMovieName)
        val imageview: ImageView = itemView!!.findViewById(R.id.ivMovie)

    }
}