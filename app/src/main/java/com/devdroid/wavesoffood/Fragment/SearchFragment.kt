package com.devdroid.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdroid.wavesoffood.Adpter.MenuAdapter
import com.devdroid.wavesoffood.R
import com.devdroid.wavesoffood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var adapter:MenuAdapter
    private val originalFoodName= listOf("Rice","Dal","Chicken","ege")
   private val originalFoodPrice= listOf("₹10","₹20","₹30","₹40")
   private val originalFoodImage:List<Int> = listOf(R.drawable.rice,R.drawable.dal,R.drawable.checken,R.drawable.egecurry)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filterMenuFoodName = mutableListOf<String>()
    private val filterMenuFoodPrice = mutableListOf<String>()
    private val filterMenuFoodImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentSearchBinding.inflate(layoutInflater,container,false)
        adapter =MenuAdapter(filterMenuFoodName,filterMenuFoodPrice,filterMenuFoodImage,requireContext())
        binding.menuRecycleView.layoutManager=LinearLayoutManager(requireContext())
        binding.menuRecycleView.adapter=adapter
        setUpSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()
        filterMenuFoodName.addAll(originalFoodName)
        filterMenuFoodPrice.addAll(originalFoodPrice)
        filterMenuFoodImage.addAll(originalFoodImage)
        adapter.notifyDataSetChanged()
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query:String) {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()
        originalFoodName.forEachIndexed { index, foodName ->
            if(foodName.contains(query,ignoreCase = true)){
                filterMenuFoodName.add(foodName)
                filterMenuFoodPrice.add(originalFoodPrice[index])
                filterMenuFoodImage.add(originalFoodImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}