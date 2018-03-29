package com.bestsellers.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.bestsellers.bookgenre.BookGenresFragment
import com.bestsellers.favorite.FavoriteFragment

/**
 * Created by Rafaela Araujo
 * on 26/02/2018.
 */
class MainPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val mFragmentList: ArrayList<Fragment> = ArrayList()
    private val mFragmentTitleList: ArrayList<String> = ArrayList()

    init{
        addFragment(BookGenresFragment(), "Best Sellers")
        addFragment(FavoriteFragment(), "Favorites")
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    private fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }


}