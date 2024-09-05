package com.saraalves.marketsearch.presentation.search

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.saraalves.marketsearch.R
import com.saraalves.marketsearch.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity(R.layout.activity_search) {

    private val binding by lazy { ActivitySearchBinding.inflate(layoutInflater) }

    private lateinit var searchFragment: SearchFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.searchActivity)

        searchFragment = SearchFragment()

        setCurrentFragment(searchFragment)

    }

    private fun setCurrentFragment(fragment: Fragment) {
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.add(R.id.flFragment, fragment)
        ft.commit()
    }
}