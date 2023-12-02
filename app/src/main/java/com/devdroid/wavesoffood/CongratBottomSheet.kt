package com.devdroid.wavesoffood

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devdroid.wavesoffood.databinding.FragmentCongratBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CongratBottomSheet : BottomSheetDialogFragment() {
  private lateinit var  binding:FragmentCongratBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          binding= FragmentCongratBottomSheetBinding.inflate(inflater,container,false)
        binding.GoHomeButton.setOnClickListener {
            val intent = Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {

    }
}