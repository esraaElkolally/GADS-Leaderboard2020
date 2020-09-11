package com.esraa.gadsleaderboard.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.esraa.gadsleaderboard.R
import com.esraa.gadsleaderboard.presentation.ui.adapters.SectionsPagerAdapter
import com.esraa.gadsleaderboard.presentation.ui.submit.SubmitActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
            }

    fun submitscreen(view: View) {
        startActivity(Intent(this,SubmitActivity::class.java))
    }
}