package com.tiashl.myapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val bottomNavigation = findViewById<MeowBottomNavigation>(R.id.bottomNavigation)

        // Initialize the MeowBottomNavigation items
        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_search))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_order))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_user))

        // Set the click listener for MeowBottomNavigation items
        bottomNavigation.setOnClickMenuListener { item ->
            when (item.id) {
                0 -> replaceFragment(HomeFragment.newInstance())
                1 -> replaceFragment(SearchFragment.newInstance())
                2 -> replaceFragment(OrderFragment.newInstance())
                3 -> replaceFragment(UserFragment.newInstance())
                else -> replaceFragment(HomeFragment.newInstance())
            }
        }

        // Initially, add the HomeFragment and select it in the bottom navigation
        addFragment(HomeFragment.newInstance())
        bottomNavigation.show(0)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(fragment::class.java.simpleName)
        fragmentTransaction.commit()
    }

    private fun addFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(fragment::class.java.simpleName)
        fragmentTransaction.commit()
    }
}
