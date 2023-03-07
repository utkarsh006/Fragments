package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Adding a Fragment
        binding.fragAdd.setOnClickListener {
            val fragment = Fragment1()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.mainContainer,fragment,"Fragment1")
            fragmentTransaction.commit()
        }

        //Removing a fragment
        binding.fragRemove.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.mainContainer)

            fragment?.let {
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        }

        //Replacing a fragment
        binding.fragReplace.setOnClickListener {
            val fragment = Fragment2()
            with(supportFragmentManager.beginTransaction()){
                replace(R.id.mainContainer,fragment)
                addToBackStack(null)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }

    }
}