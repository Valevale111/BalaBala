package com.example.balabala

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : FragmentActivity() {
    private val tabNames = arrayOf("直播","推荐","热门","动画","影视","MSI","公众科学日","新征程")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(GlobalVariables.page_num==0){
            findViewById<ImageView>(R.id.homeIcon).setImageResource(R.drawable.home_pink)
        }

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        //减小page页面缓冲数量
        viewPager.offscreenPageLimit = 1
        val tabLayout = findViewById<TabLayout>(R.id.topGuide)
        val adapter = PagerAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter = adapter

        // 设置 ViewPager2 的初始位置
        viewPager.setCurrentItem(1, false)

        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            tab.text = tabNames[position]
        }.attach()

        val searchButton = findViewById<TextView>(R.id.search_bar)
        searchButton.setOnClickListener{
            val intent = Intent(this,SearchActivity::class.java)
            startActivity(intent)
        }
    }
}
