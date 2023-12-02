package com.devdroid.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.devdroid.wavesoffood.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var navControloer=findNavController(R.id.fragmentContainerView3)
        var bottomNavController=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavController.setupWithNavController(navControloer)
        binding.notificationButton.setOnClickListener {
            val bottomSheetDialog =notification_button_fragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
    }
}