package com.atakan.foodmarkethub.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.atakan.foodmarkethub.R
import com.atakan.foodmarkethub.databinding.FragmentOrderSuccessBinding

class OrderSuccessFragment : Fragment() {
    private lateinit var tasarim: FragmentOrderSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim =
            DataBindingUtil.inflate(inflater, R.layout.fragment_order_success, container, false)
        return tasarim.root
    }


}