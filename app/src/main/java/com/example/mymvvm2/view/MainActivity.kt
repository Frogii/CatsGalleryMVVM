package com.example.mymvvm2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mymvvm2.R
import com.example.mymvvm2.adapter.CatAdapter
import com.example.mymvvm2.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var adapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        if (viewModel.catsList.value == null)
            viewModel.getCats()

        viewModel.catsList.observe(this, {
            adapter.setCatList(it)
        })

        adapter = CatAdapter(this)
        recycler_view.adapter = adapter
    }
}