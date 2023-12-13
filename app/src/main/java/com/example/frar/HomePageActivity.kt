package com.example.frar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.frar.databinding.ActivityHomePageBinding


class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomePageFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> replaceFragment(HomePageFragment())
                R.id.profile -> replaceFragment(Profile())
                R.id.recommendation -> replaceFragment(Recommendation())

                else -> {

                }

            }
            true
        }

    }


    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }
}