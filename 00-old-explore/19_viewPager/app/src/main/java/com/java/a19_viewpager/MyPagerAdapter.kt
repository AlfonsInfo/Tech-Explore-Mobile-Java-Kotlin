package com.java.a19_viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class MyPagerAdapter(var context: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val modelCourse = ModelCourse.values()[position]
        val inflater = LayoutInflater.from(context)

        val layout = inflater.inflate(modelCourse.mLayout,container,false)

        container.addView(layout)
        return layout
    }

    override fun getCount(): Int {
//        return 2;
        return ModelCourse.values().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val customPagerEnum = ModelCourse.values()[position]
        return context.getString(customPagerEnum.mTitle)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

    }
}