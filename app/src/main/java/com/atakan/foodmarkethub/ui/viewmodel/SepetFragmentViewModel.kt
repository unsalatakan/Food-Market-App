package com.atakan.foodmarkethub.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atakan.foodmarkethub.data.entity.Sepet
import com.atakan.foodmarkethub.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SepetFragmentViewModel @Inject constructor(var yrepo: YemeklerDaoRepository) : ViewModel() {
    var sepetListesi = MutableLiveData<List<Sepet>>()

    init {
        sepetiYukle()
        sepetListesi = yrepo.sepetiGetir()
    }

    fun sil(sepet_yemek_id: Int, kullanici_adi: String) {
        yrepo.sepetYemekSil(sepet_yemek_id, kullanici_adi)
    }

    fun sepetiYukle() {
        yrepo.tumSepetiGoster()
    }

}