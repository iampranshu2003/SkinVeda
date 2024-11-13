 package com.example.androidapp

 import android.content.Intent
 import android.os.Bundle
 import android.view.MenuItem
 import androidx.appcompat.app.ActionBarDrawerToggle
 import androidx.appcompat.app.AppCompatActivity
 import androidx.core.view.GravityCompat
 import androidx.fragment.app.Fragment
 import androidx.fragment.app.FragmentManager
 import androidx.fragment.app.FragmentTransaction
 import com.example.androidapp.BottomNav.CureFragment
 import com.example.androidapp.BottomNav.ExploreFragment
 import com.example.androidapp.BottomNav.HomeFragment
 import com.example.androidapp.BottomNav.ProfileFragment
 import com.example.androidapp.NavMenu.DrinksFragment
 import com.example.androidapp.NavMenu.FactsFragment
 import com.example.androidapp.NavMenu.RecipeFragment
 import com.example.androidapp.NavMenu.YogaFragment
 import com.example.androidapp.databinding.ActivityMainBinding
 import com.google.android.material.navigation.NavigationView

 class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
     private lateinit var fragmentManager: FragmentManager
     private lateinit var binding: ActivityMainBinding

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

         setSupportActionBar(binding.toolbar)

         val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.nav_open, R.string.nav_close)
         binding.drawerLayout.addDrawerListener(toggle)
         toggle.syncState()

         binding.navigationDrawer.setNavigationItemSelectedListener(this)

         binding.bottomNavigation.background = null
         binding.bottomNavigation.setOnItemSelectedListener { item ->
             when (item.itemId){
                 R.id.bottom_home -> openFragment(HomeFragment())
                 R.id.bottom_profile -> openFragment(ProfileFragment())
                 R.id.bottom_cure -> openFragment(CureFragment())
                 R.id.bottom_explore -> openFragment(ExploreFragment())
             }
             true
         }

         fragmentManager = supportFragmentManager
         openFragment(HomeFragment())

         binding.fab.setOnClickListener {
             val intent = Intent(this, CameraActivity::class.java)
             startActivity(intent)
         }

     }

     override fun onNavigationItemSelected(item: MenuItem): Boolean {
         when(item.itemId){
             R.id.nav_recipe -> openFragment(RecipeFragment())
             R.id.nav_drink -> openFragment(DrinksFragment())
             R.id.nav_yoga -> openFragment(YogaFragment())
             R.id.nav_SkinFacts -> openFragment(FactsFragment())
             //R.id.nav_future -> Toast.makeText(this, "Future", Toast.LENGTH_SHORT).show()
         }
         binding.drawerLayout.closeDrawer(GravityCompat.START)
         return true
     }

     override fun onBackPressed() {
         if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
             binding.drawerLayout.closeDrawer(GravityCompat.START)
         } else {
             super.onBackPressedDispatcher.onBackPressed()
         }

     }
     private fun openFragment(fragment: Fragment){
         val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
         fragmentTransaction.replace(R.id.fragment_container, fragment)
         fragmentTransaction.commit()
     }
 }