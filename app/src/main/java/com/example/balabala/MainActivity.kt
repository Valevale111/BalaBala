package com.example.balabala

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : FragmentActivity() {
    private val tabNames = arrayOf("音乐" ,"推荐","热门","动画","影视","MSI","公众科学日","新征程")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(GlobalVariables.page_num!=0) GlobalVariables.page_num=0
        setContentView(R.layout.activity_main)
        findViewById<ImageView>(R.id.homeIcon).setImageResource(R.drawable.home_pink)

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

        val meButton:ImageView = findViewById(R.id.meIcon)
        meButton.setOnClickListener{
            val intent = Intent(this,MeActivity::class.java)
            // Create the options for the transition
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair(meButton as View, "shared_element_image")
            )

            // Start ActivityB with the transition
            startActivity(intent, options.toBundle())
        }
    }
}

