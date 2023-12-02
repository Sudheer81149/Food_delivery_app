package com.devdroid.wavesoffood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdroid.wavesoffood.Adpter.NotificationAdapter
import com.devdroid.wavesoffood.databinding.FragmentNotificationButtonFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class notification_button_fragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentNotificationButtonFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationButtonFragmentBinding.inflate(layoutInflater,container,false)
        val notifications= listOf("Your order has been Canceled Successfully","Order has been taken by the driver","Congrats Your Order Placed")
        val notificationsImage= listOf(R.drawable.sademoji,R.drawable.driver,R.drawable.successful)
       val adapter=NotificationAdapter(ArrayList(notifications), ArrayList(notificationsImage))
        binding.notificationRecycleview.adapter=adapter
        binding.notificationRecycleview.layoutManager=LinearLayoutManager(requireContext())
         return binding.root
    }

    companion object {

    }
}