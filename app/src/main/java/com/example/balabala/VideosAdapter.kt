package com.example.balabala

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideosAdapter(val videosList:List<Video>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    //定义回调接口，用于在持有context的activity中相应点击-activity跳转事件
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoTitle: TextView = itemView.findViewById(R.id.videoName)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val videoImage:ImageView = view.findViewById(R.id.image)
        val videoName :TextView = view.findViewById(R.id.videoName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_item_layout,parent,false)
        val viewHolder =  ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videosList[position]
        holder.videoImage.setImageResource(video.imageId)
        holder.videoName.text = video.name
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = videosList.size
}