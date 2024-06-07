package com.example.balabala

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.balabala.ui.theme.BalaBalaTheme
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class VideoAvtivity : FragmentActivity() {

    private val tabNames = arrayOf("简介", "评论")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager2)
        //减小page页面缓冲数量
        viewPager.offscreenPageLimit = 1
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val editText:EditText = findViewById(R.id.searchEditText)
        val adapter =RecommendReviewAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        // 设置 ViewPager 的初始位置，默认为视频简介和推荐页面
        viewPager.setCurrentItem(0, false)

        //关联滑动条和viewpager的两个fragment
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }
}
