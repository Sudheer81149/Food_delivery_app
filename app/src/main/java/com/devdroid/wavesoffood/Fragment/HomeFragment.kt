package com.devdroid.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.devdroid.wavesoffood.Adpter.PopularAdapter
import com.devdroid.wavesoffood.R
import com.devdroid.wavesoffood.databinding.FragmentHomeBinding
import org.jetbrains.annotations.TestOnly
import org.w3c.dom.Text


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        binding.viewMenuAll.setOnClickListener {
            val buttonSheetDialog=MenuBottonSheetFragment()
            buttonSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList= ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        val imageSlider=binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition=imageList[position]
                val itemMessage="selected item is $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_LONG).show()
            }
        })
        val foodName= listOf("Rice","Dal","Chicken","ege")
        val price= listOf("₹10","₹20","₹30","₹40")
        val foodImage= listOf(R.drawable.rice,R.drawable.dal,R.drawable.checken,R.drawable.egecurry)
        val adapter=PopularAdapter(foodName,price,foodImage,requireContext())
        binding.popularRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter=adapter
    }


    companion object {

    }
}