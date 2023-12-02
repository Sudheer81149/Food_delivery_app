package com.devdroid.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devdroid.wavesoffood.databinding.ActivityStartBinding

class Start_activity : AppCompatActivity() {
    private val binding:ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.nextbutton.setOnClickListener {
            val intent = Intent(this,login_activity::class.java)
            startActivity(intent)
        }
    }
}