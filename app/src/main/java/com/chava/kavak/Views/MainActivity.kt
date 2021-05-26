package com.chava.kavak.Views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chava.kavak.R
import com.chava.kavak.databinding.ActivityMainBinding
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val URL = "https://raw.githubusercontent.com/rrafols/mobile_test/"
    private lateinit var skeleton: Skeleton
    lateinit var retrofit: Retrofit
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        skeleton = binding.rv.applySkeleton(R.layout.item)
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun loading(){
        skeleton.showSkeleton()
    }
    private fun ready(){
        skeleton.showOriginal()
    }
}