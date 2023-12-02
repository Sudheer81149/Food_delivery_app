package com.devdroid.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdroid.wavesoffood.Adpter.BuyAgainAdapter
import com.devdroid.wavesoffood.R
import com.devdroid.wavesoffood.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding:FragmentHistoryBinding
    private lateinit var buyAgainAdapter:BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          binding=FragmentHistoryBinding.inflate(layoutInflater,container,false)
           setUpRecyclerView()
        return binding.root
    }
    private fun setUpRecyclerView(){
        val buyAgainFoodName= arrayListOf("Food 1","Food 2","Food 3","Food 4")
        val buyAgainFoodPrice= arrayListOf("₹100","₹200","₹300","₹400")
        val buyAgainFoodImage= arrayListOf(R.drawable.rice,R.drawable.dal,R.drawable.checken,R.drawable.egecurry)
        buyAgainAdapter= BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.buyAgainFoodRecyclerView.adapter=buyAgainAdapter
        binding.buyAgainFoodRecyclerView.layoutManager=LinearLayoutManager(requireContext())
    }

    companion object {

    }
}