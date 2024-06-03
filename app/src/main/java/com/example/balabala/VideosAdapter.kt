package com.example.balabala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideosAdapter(val videosList:List<Video>) :
    RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val videoImage:ImageView = view.findViewById(R.id.image)
        val videoName :TextView = view.findViewById(R.id.videoName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videosList[position]
        holder.videoImage.setImageResource(video.imageId)
        holder.videoName.text = video.name
    }

    override fun getItemCount(): Int = videosList.size
}