package com.anupkumar.androidlivedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    lateinit var progressBar:ProgressBar

    lateinit var viewModel: ViewModel

    lateinit var listView: ListView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)

        progressBar= findViewById(R.id.progressbar)

        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java!!)

        viewModel.getFruitList().observe(this, Observer {

            val prodAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, it)
            listView.adapter = prodAdapter

            progressBar.visibility = View.GONE

        })

    }
}
