package com.java.a20_tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(var fragmentManager: FragmentManager, var numOfTabs : Int  = 0 ) : FragmentPagerAdapter(fragmentManager) {


    override fun getCount(): Int {
        return numOfTabs
    }


    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> ChatFragment()
            1 -> StatusFragment()
            2 -> CallsFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title = ""
        if(position == 0){ title="Chats"}
        else if(position == 1){title="Status"}
        else if(position == 2){title="Calls"}
        return title
    }
}