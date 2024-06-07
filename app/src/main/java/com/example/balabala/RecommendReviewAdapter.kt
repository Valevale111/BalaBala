package com.example.balabala

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class RecommendReviewAdapter(manager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(manager,lifecycle){
        override fun getItemCount(): Int =2

        override fun createFragment(position: Int): Fragment {
            RecommendReviewFragment.currentLoc = position
            return RecommendReviewFragment()
        }
}