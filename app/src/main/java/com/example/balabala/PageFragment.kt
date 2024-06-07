package com.example.balabala

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PageFragment():Fragment(),VideosAdapter.OnItemClickListener {
    companion object{
        var currentLoc = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return when (currentLoc){
            0 -> inflater.inflate(R.layout.pager_layout_1,container,false)
            1 -> inflater.inflate(R.layout.pager_layout_home,container,false)
            2 -> inflater.inflate(R.layout.pager_layout_3,container,false)
            3 -> inflater.inflate(R.layout.pager_layout_4,container,false)
            4 -> inflater.inflate(R.layout.pager_layout_5,container,false)
            5 -> inflater.inflate(R.layout.pager_layout_6,container,false)
            6 -> inflater.inflate(R.layout.pager_layout_7,container,false)
            7 -> inflater.inflate(R.layout.pager_layout_8,container,false)
            else -> inflater.inflate(R.layout.pager_default_layout,container,false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pageNumber = currentLoc
        handlePageLogic(pageNumber)
    }

    private fun handlePageLogic(pageNumber: Int) {

        when (pageNumber) {
            0 -> handlePage1Logic()
            1 -> handlePage2Logic()
            // 添加更多的case来处理更多的页面
            else -> handleDefaultPageLogic()
        }
    }

    private fun handlePage1Logic() {
        // 页面1的特定逻辑
    }

    private val list = ArrayList<Video>()

    override fun onItemClick(position: Int) {
        val intent = Intent(activity,VideoAvtivity::class.java)
        //通过键值对向VideoActivity传递当前点击的视频项的位置数据
        intent.putExtra("ITEM_POSITION", position)
        startActivity(intent)
    }

    // 页面home的特定逻辑
    private fun handlePage2Logic() {
        initVideos(list)
        val context = requireContext()
        val layoutManager = GridLayoutManager(context,2)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.videosLayout)
        val videosAdapter = VideosAdapter(list,this)
        recyclerView?.adapter = videosAdapter
        recyclerView?.layoutManager = layoutManager
    }

    private fun initVideos(list:ArrayList<Video>){
        list.add(Video("apple",R.drawable.apple_pic))
        list.add(Video("banana",R.drawable.banana_pic))
        list.add(Video("orange",R.drawable.orange_pic))
        list.add(Video("watermelon",R.drawable.watermelon_pic))
        list.add(Video("pear",R.drawable.pear_pic))
        list.add(Video("grape",R.drawable.grape_pic))
        list.add(Video("pineapple",R.drawable.pineapple_pic))
        list.add(Video("strawberry",R.drawable.strawberry_pic))
        list.add(Video("cherry",R.drawable.cherry_pic))
        list.add(Video("mango",R.drawable.mango_pic))
    }

    private fun handleDefaultPageLogic() {
        // 默认页面的通用逻辑
    }
}