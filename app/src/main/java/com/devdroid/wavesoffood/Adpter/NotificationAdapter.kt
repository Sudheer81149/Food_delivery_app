package com.devdroid.wavesoffood.Adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devdroid.wavesoffood.databinding.NotificationItemsBinding

class NotificationAdapter(private var notification:ArrayList<String>,private var notificationImage:ArrayList<Int>): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding=NotificationItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int {
        return notification.size
    }

    inner  class NotificationViewHolder(private val binding:NotificationItemsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notificationTextView.text=notification[position]
                notificationImageView.setImageResource(notificationImage[position])
            }
        }

    }
}