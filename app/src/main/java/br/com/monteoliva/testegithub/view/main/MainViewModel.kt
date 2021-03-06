package br.com.monteoliva.testegithub.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import br.com.monteoliva.testegithub.model.gson.Item

class MainViewModel: ViewModel() {
    val itensLiveData: MutableLiveData<MutableList<Item>> by lazy {
        MutableLiveData<MutableList<Item>>()
    }

    fun setList(list: MutableList<Item>) {
        if (itensLiveData.value == null) {
            itensLiveData.postValue(list)
        }
    }

    fun updateList(list: MutableList<Item>) {
        itensLiveData.value?.clear()
        itensLiveData.postValue(list)
    }

    val list: MutableList<Item> get() = itensLiveData.value!!
}