package com.devdroid.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.devdroid.wavesoffood.databinding.ActivityChooseLocationBinding

class chooseLocationActivity : AppCompatActivity() {
    private val binding:ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationlist= arrayOf("Bhubaneswar","gop","nimapada","konark")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,locationlist)
        val autocompletetextview=binding.listoflocation
        autocompletetextview.setAdapter(adapter)
    }
}