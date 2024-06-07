package com.example.balabala

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecommendReviewFragment():Fragment() {

    companion object{
        var currentLoc = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return when (currentLoc){
            0 -> inflater.inflate(R.layout.recommend_layout,container,false)
            1 -> inflater.inflate(R.layout.review_layout,container,false)
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
            0 -> handleRecommendLogic()
            1 -> handleReviewLogic()
            // 添加更多的case来处理更多的页面
            else -> handleDefaultPageLogic()
        }
    }

    // recommend的特定逻辑(视频简介和下拉推荐，使用recyclerView可滑动)
    private fun handleRecommendLogic() {

    }

    // review页面的特定逻辑（使用recyclerView，下方还有一个固定在上层的评论条，考虑用toolBar）
    private fun handleReviewLogic() {
    }

    // 默认页面的通用逻辑（考虑作为一个统一的崩溃界面？，简化处理即可）
    private fun handleDefaultPageLogic() {

    }
}