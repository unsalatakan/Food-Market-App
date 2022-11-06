package com.atakan.foodmarkethub.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.atakan.foodmarkethub.R
import com.atakan.foodmarkethub.databinding.FragmentYemekDetayBinding
import com.atakan.foodmarkethub.ui.viewmodel.YemekDetayFragmentViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YemekDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentYemekDetayBinding
    private lateinit var viewModel: YemekDetayFragmentViewModel

    var adet = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_detay, container, false)
        tasarim.yemekDetayFragment = this

        val bundle: YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${gelenYemek.yemek_resim_adi}"
        Picasso.get().load(url).into(tasarim.ivYemekGorsel)

        tasarim.tvYemekAdi.text = gelenYemek.yemek_adi
        tasarim.tvYemekFiyat.text = "${gelenYemek.yemek_fiyat} ₺"
        tasarim.tvYemekAdet.text = "${adet}"

        tasarim.btnEksi.setOnClickListener {
            if (adet > 1) {
                adet--
                tasarim.tvYemekAdet.text = "${adet}"
                tasarim.tvYemekFiyat.text = "${adet * gelenYemek.yemek_fiyat} ₺"
            }
        }

        tasarim.btnArti.setOnClickListener {
            adet++
            tasarim.tvYemekAdet.text = "${adet}"
            tasarim.tvYemekFiyat.text = "${adet * gelenYemek.yemek_fiyat} ₺"
        }

        tasarim.btnSepeteEkle.setOnClickListener {
            buttonSepeteEkleTikla(
                gelenYemek.yemek_adi,
                gelenYemek.yemek_resim_adi,
                gelenYemek.yemek_fiyat,
                adet,
                "AtakanUnsal"
            )
        }

        tasarim.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temptViewModel: YemekDetayFragmentViewModel by viewModels()
        viewModel = temptViewModel
    }

    fun buttonSepeteEkleTikla(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ) {
        viewModel.sepeteEkle(
            yemek_adi,
            yemek_resim_adi,
            yemek_fiyat,
            yemek_siparis_adet,
            kullanici_adi
        )
    }
}