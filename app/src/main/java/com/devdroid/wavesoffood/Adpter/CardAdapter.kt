package com.devdroid.wavesoffood.Adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devdroid.wavesoffood.databinding.CartItemBinding

class CardAdapter(private val CardItems:MutableList<String>,private val CardItemPrice:MutableList<String>,private val CardImage:MutableList<Int>): RecyclerView.Adapter<CardAdapter.CardHolder>() {
    private val CardItemsQuanties = IntArray(CardItems.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return CardItems.size
    }

    inner class CardHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = CardItemsQuanties[position]
                foodName.text = CardItems[position]
                price.text = CardItemPrice[position]
                foodImage.setImageResource(CardImage[position])
                itemQuantity.text = quantity.toString()
                minusButton.setOnClickListener {
                    deceaseQuantity(position)
                }
                plusButton.setOnClickListener {
                    increaseQuantity(position)
                }
                delectButton.setOnClickListener {
                    val itemPosition=adapterPosition
                    if(itemPosition !=RecyclerView.NO_POSITION){
                        deleteQuantity(itemPosition)
                    }
                }
            }
        }

        private fun deceaseQuantity(position: Int) {
            if (CardItemsQuanties[position] > 1) {
                CardItemsQuanties[position]--
                binding.itemQuantity.text = CardItemsQuanties[position].toString()
            }
        }

        private fun increaseQuantity(position: Int) {
            if (CardItemsQuanties[position] < 10) {
                CardItemsQuanties[position]++
                binding.itemQuantity.text = CardItemsQuanties[position].toString()
            }
        }
        private fun deleteQuantity(position: Int) {
           CardItems.removeAt(position)
            CardImage.removeAt(position)
            CardItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,CardItems.size)
        }
    }
}