package com.java.a20_tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var tabItemChats : TabItem
    private lateinit var tabItemStatus : TabItem
    private lateinit var tabItemCalls : TabItem
    private lateinit var viewPager: ViewPager

    private fun initWidget(){
        //Layout Tab
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
//        tabLayout.addTab(tabLayout.newTab().setText("Chat"));
//        tabLayout.addTab(tabLayout.newTab().setText("Status"));
//        tabLayout.addTab(tabLayout.newTab().setText("Calls"));
//        //Item Tab
//        tabItemChats = findViewById(R.id.tabChats)
//        tabItemStatus = findViewById(R.id.tabStatus)
//        tabItemCalls = findViewById(R.id.tabCalls)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWidget()

        //Adapter
        val pagerAdapter = MyPagerAdapter(supportFragmentManager, tabLayout.tabCount)
        //Set Adapter for the view
        viewPager.adapter  = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)


    }


}