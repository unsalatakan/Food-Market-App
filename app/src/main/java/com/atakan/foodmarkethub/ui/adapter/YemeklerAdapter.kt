package com.atakan.foodmarkethub.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.atakan.foodmarkethub.R
import com.atakan.foodmarkethub.databinding.YemekCardTasarimBinding
import com.atakan.foodmarkethub.data.entity.Yemekler
import com.atakan.foodmarkethub.ui.fragment.YemekListeFragmentDirections
import com.atakan.foodmarkethub.ui.viewmodel.YemekListeFragmentViewModel
import com.atakan.foodmarkethub.util.gecisYap
import com.squareup.picasso.Picasso

class YemeklerAdapter(
    var mContext: Context,
    var yemeklerListesi: List<Yemekler>,
    var viewModel: YemekListeFragmentViewModel
) : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: YemekCardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: YemekCardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim: YemekCardTasarimBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.yemek_card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim
        t.textViewYemekAd.text = "${yemek.yemek_adi}"
        t.textViewYemekFiyat.text = "${yemek.yemek_fiyat} ₺"

        t.satirCard.setOnClickListener {
            val gecis = YemekListeFragmentDirections.yemekDetayGecis(yemek = yemek)
            Navigation.gecisYap(it, gecis)
        }

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Picasso.get().load(url).into(t.imageViewYemekGorsel)
    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }
}