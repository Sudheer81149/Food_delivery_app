package com.devdroid.wavesoffood.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdroid.wavesoffood.Adpter.CardAdapter
import com.devdroid.wavesoffood.R
import com.devdroid.wavesoffood.databinding.FragmentCartBinding
import com.devdroid.wavesoffood.payoutActivity

class CartFragment : Fragment() {
   private lateinit var binding:FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCartBinding.inflate(inflater,container,false)
        val FoodName= listOf("chicken curry","mutton curry","soaibini curry","Alu curry")
        val FoodPrice= listOf("₹100","₹120","₹70","₹90")
        val FoodImage= listOf(R.drawable.checken,R.drawable.egecurry,R.drawable.dal,R.drawable.rice)
        val adapter= CardAdapter(ArrayList(FoodName),ArrayList(FoodPrice),ArrayList(FoodImage))
        binding.cardRecyclerview.layoutManager= LinearLayoutManager(requireContext())
        binding.cardRecyclerview.adapter=adapter
        binding.proceedButton.setOnClickListener {
            val intent =Intent(requireContext(),payoutActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {

    }
}