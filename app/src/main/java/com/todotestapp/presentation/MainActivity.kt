package com.todotestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.todotestapp.R
import com.todotestapp.presentation.features.home.HomeFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fl_container, HomeFragment())
                .commit()
        }
    }
}