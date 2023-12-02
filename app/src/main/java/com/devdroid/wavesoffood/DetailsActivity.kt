package com.devdroid.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devdroid.wavesoffood.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val foodName=intent.getStringExtra("MenuItemName")
        val foodImage=intent.getIntExtra("MenuItemImage",0)
        binding.DetailsFoodName.text=foodName
        binding.DetailsFoodImage.setImageResource(foodImage)
        binding.imageButton.setOnClickListener {
            finish()
        }
    }
}