package com.devdroid.wavesoffood.Adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devdroid.wavesoffood.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val BuyAgainFoodName:ArrayList<String>,private val BuyAgainFoodPrice:ArrayList<String>,private val BuyAgainFoodImage:ArrayList<Int>):
    RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding=BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }



    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(BuyAgainFoodName[position],BuyAgainFoodPrice[position],BuyAgainFoodImage[position])
    }
    override fun getItemCount(): Int {
        return BuyAgainFoodName.size
    }
    inner  class BuyAgainViewHolder(private val binding: BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(FoodName: String, FoodPrice: String, FoodImage: Int) {
            binding.BuyAgainFoodName.text=FoodName
            binding.BuyAgainFoodPrice.text=FoodPrice
            binding.BuyAgainFoodImage.setImageResource(FoodImage)
        }

    }
}