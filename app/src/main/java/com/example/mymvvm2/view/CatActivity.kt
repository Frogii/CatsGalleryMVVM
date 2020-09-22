package com.example.mymvvm2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mymvvm2.R
import kotlinx.android.synthetic.main.activity_cat.*

class CatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat)

        if (intent.hasExtra("id") && intent.hasExtra("imageUrl")) {
            cat_id2.text = intent.getStringExtra("id")
            Glide
                .with(this)
                .load(intent.getStringExtra("imageUrl"))
                .into(cat_full_image)
        }
    }
}