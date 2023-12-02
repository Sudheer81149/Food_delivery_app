package com.devdroid.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdroid.wavesoffood.Adpter.CardAdapter
import com.devdroid.wavesoffood.Adpter.MenuAdapter
import com.devdroid.wavesoffood.R
import com.devdroid.wavesoffood.databinding.FragmentMenuBottonSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottonSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentMenuBottonSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottonSheetBinding.inflate(inflater,container,false)
        binding.buttonBack.setOnClickListener {
            dismiss()
        }
        val foodName= listOf("chicken curry","mutton curry","soaibini curry","Alu curry")
        val foodPrice= listOf("₹100","₹120","₹70","₹90")
        val foodImage= listOf(R.drawable.checken,R.drawable.egecurry,R.drawable.dal,R.drawable.rice)
        val adapter= MenuAdapter(ArrayList(foodName),ArrayList(foodPrice),ArrayList(foodImage),requireContext())
        binding.menuRecycleView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecycleView.adapter=adapter
        return binding.root
    }

    companion object {

    }
}