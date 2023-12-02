package com.devdroid.wavesoffood.Adpter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devdroid.wavesoffood.DetailsActivity
import com.devdroid.wavesoffood.databinding.PopularItemBinding

class PopularAdapter(private val items:List<String>,private val price:List<String>,private val image:List<Int>,private val requiredContex: Context): RecyclerView.Adapter<PopularAdapter.PopulerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopulerViewHolder {
        return PopulerViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopulerViewHolder, position: Int) {
        val item =items[position]
        val images=image[position]
        val prices=price[position]
        holder.bind(item,prices,images)
        holder.itemView.setOnClickListener {
            val intent = Intent(requiredContex , DetailsActivity::class.java)
            intent.putExtra("MenuItemName",items.get(position))
            intent.putExtra("MenuItemImage",image.get(position))
            requiredContex.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class PopulerViewHolder(private val binding:PopularItemBinding):RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.menuImage
        fun bind(item: String,prices:String ,images: Int) {
            binding.menuFoodName.text=item
            binding.menuPrice.text=prices
            imageView.setImageResource(images)
        }

    }
}