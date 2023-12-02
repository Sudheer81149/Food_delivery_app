package com.devdroid.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devdroid.wavesoffood.databinding.ActivityPayoutBinding

class payoutActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.placeOrderButton.setOnClickListener {
            val BottomSheetDialog =CongratBottomSheet()
            BottomSheetDialog.show(supportFragmentManager,"Test")
        }
        binding.imageButton.setOnClickListener {
            finish()
        }
    }
}