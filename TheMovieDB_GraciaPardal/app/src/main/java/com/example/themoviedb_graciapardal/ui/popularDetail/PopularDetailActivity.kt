package com.example.themoviedb_graciapardal.ui.popularDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.themoviedb_graciapardal.R
import com.example.themoviedb_graciapardal.ui.Populares.MyPopularRecyclerViewAdapter

class PopularDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_detail)

        val id = intent.extras?.getString(getString(R.string.extra_id))

        //TODO SETEAR LOS VALORES ¿COMO?

    }
}