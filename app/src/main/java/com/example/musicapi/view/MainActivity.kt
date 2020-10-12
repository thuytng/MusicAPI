package com.example.musicapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.example.musicapi.R
import com.example.musicapi.model.MusicAPI
import com.example.musicapi.model.MusicResponse
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    internal lateinit var viewPagerAdapter:ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tablayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(this.viewpager))
        this.viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(this.tablayout))
//        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

//        this.viewpager.adapter = viewPagerAdapter  //Binding PagerAdapter with ViewPager
//        this.tablayout.setupWithViewPager(this.viewpager)

    }

    private fun initNetworkCall() {
//        MusicAPI.initRetrofit(this.tablayout)
    }
}