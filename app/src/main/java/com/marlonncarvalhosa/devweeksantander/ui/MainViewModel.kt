package com.marlonncarvalhosa.devweeksantander.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marlonncarvalhosa.devweeksantander.model.Conta
import com.marlonncarvalhosa.devweeksantander.model.local.Repository

class MainViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente(): LiveData<Conta> {
        mutableLiveData.value = Repository().getLocalData()

        return  mutableLiveData
    }

}