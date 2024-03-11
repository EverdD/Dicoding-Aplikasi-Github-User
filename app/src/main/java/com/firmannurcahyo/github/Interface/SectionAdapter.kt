package com.firmannurcahyo.github.Interface

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.firmannurcahyo.github.R

//Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy

class SectionAdapter(private val context: Context, fm: FragmentManager, data: Bundle) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentBundle: Bundle = data

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.followers, R.string.following)
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FollowersFragment().apply { arguments = fragmentBundle }
            1 -> FollowingFragment().apply { arguments = fragmentBundle }
            else -> throw IllegalStateException("Invalid position: $position")
        }
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
    //Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }
}