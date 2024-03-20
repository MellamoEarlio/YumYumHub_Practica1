package com.example.yumyumhub.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.yumyumhub.BlancoFragment
import com.example.yumyumhub.NegroFragment
import java.lang.IllegalArgumentException

class ViewPagerAdapter(fa:FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int=2
    override fun createFragment(position: Int): Fragment {
        return when (position){

            0 -> BlancoFragment()
            1 -> NegroFragment()

            else -> throw IllegalArgumentException("Posicion invalida: $position")

        }
    }
}