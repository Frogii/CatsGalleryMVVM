package com.example.mymvvm2.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mymvvm2.network.model.CatItem
import com.example.mymvvm2.repository.MainActivityRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MainActivityRepository(application)
    val catsList: LiveData<List<CatItem>>

    init {
        this.catsList = repository.catsList
    }

    fun getCats() {
        repository.getCats()
    }


}