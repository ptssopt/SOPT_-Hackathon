package com.computer.inu.sopt_hackathon_pts.Adapter

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.computer.inu.sopt_hackathon_pts.DB.SharedPreferenceController
import com.computer.inu.sopt_hackathon_pts.R
import com.computer.inu.sopt_hackathon_pts.data.ImageData
import com.computer.inu.sopt_hackathon_pts.network.ApplicationController
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageRecyclerAdapter(val ctx: Context, val dataList: ArrayList<ImageData>) : RecyclerView.Adapter<ImageRecyclerAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_image, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx).load(dataList[position].Image).into(holder.image)
        holder.image.setOnClickListener {
            // intent
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image : ImageView =itemView.findViewById(R.id.rv_item_image2) as ImageView

    }

}