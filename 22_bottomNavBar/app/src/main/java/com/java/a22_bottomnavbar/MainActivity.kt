package com.java.a22_bottomnavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var profileFragment = ProfileFragment()
    private var homeFragment = HomeFragment()
    private var settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Bottom Navigation Config
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.home_menu
        //Frame layout on main_activity.xml set the id FragmentContainer
        //BottomNavigationView, set the constraint to bottom
        //Connect to menu
        // make menu
    }

    private fun setFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment  ).commit()
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            (R.id.profile_menu) -> {
                setFragment(profileFragment)
                return true
            }
            (R.id.home_menu) -> {
                setFragment(homeFragment)
                return true
            }
            (R.id.settings_menu) -> {
                setFragment(settingsFragment)
                return true
            }
            else->{
                return false
            }
        }
    }
}


