package com.atakan.foodmarkethub.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.atakan.foodmarkethub.R
import com.atakan.foodmarkethub.ui.adapter.YemeklerAdapter
import com.atakan.foodmarkethub.databinding.FragmentYemekListeBinding
import com.atakan.foodmarkethub.ui.viewmodel.YemekListeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YemekListeFragment : Fragment() {
    private lateinit var tasarim: FragmentYemekListeBinding
    private lateinit var viewModel: YemekListeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_liste, container, false)
        tasarim.yemekListeFragment = this
        tasarim.yemekListeToolbarBaslik = "YEMEK LİSTESİ"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        viewModel.yemeklerListesi.observe(viewLifecycleOwner) {
            val adapter = YemeklerAdapter(requireContext(), it, viewModel)
            tasarim.yemeklerAdapter = adapter
        }
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YemekListeFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }


}