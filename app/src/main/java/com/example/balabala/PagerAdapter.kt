package com.example.balabala

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(manager:FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(manager,lifecycle){

    override fun getItemCount(): Int =8

    override fun createFragment(position: Int): Fragment {
        PageFragment.currentLoc = position
        return PageFragment()
    }
}