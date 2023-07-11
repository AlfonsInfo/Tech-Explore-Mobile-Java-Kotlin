package com.java.a21_navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var mDrawer : DrawerLayout
    private lateinit var toolbar : Toolbar
    private lateinit var navigationView: NavigationView
    private lateinit var drawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Tool bar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        //Drawer
        mDrawer = findViewById(R.id.myDrawerLayout)

        //Drawer Navigation
        navigationView = findViewById(R.id.nvView)
        setupDrawerContent(navigationView)
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Tindakan yang ingin Anda lakukan ketika item menu dipilih
            selectDrawerItem(menuItem)
            true
        }
    }

    private fun selectDrawerItem(menuItem: MenuItem){
        var  fragment : Fragment = FirstFragment::class.java.newInstance()
        var fragmentClass : Class<*> = FirstFragment::class.java

        when(menuItem.itemId){
            (R.id.nav_first_fragment) ->{
                fragmentClass = FirstFragment::class.java
            }
            (R.id.nav_second_fragment)->{
                fragmentClass = SecondFragment::class.java
            }
            (R.id.nav_third_fragment)->{
                fragmentClass = ThirdFragment::class.java
            }
        }

        try{
            fragment = fragmentClass.newInstance() as Fragment
        }catch (e : IllegalAccessException){
            e.printStackTrace()
        }catch(e : InstantiationException)
        {
            e.printStackTrace()
        }

        var fm : FragmentManager = supportFragmentManager
        fm.beginTransaction().replace(R.id.flContent,fragment).commit()
        menuItem.isCheckable = true
        title = menuItem.title
        mDrawer.closeDrawer(navigationView)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            android.R.id.home -> {
                mDrawer.openDrawer(GravityCompat.START)
                return true;
            }
        }

        return super.onOptionsItemSelected(item)
    }
}