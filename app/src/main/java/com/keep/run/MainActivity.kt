package com.keep.run

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.keep.run.bean.LoadState
import com.keep.run.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.loadState.observe(this, Observer {
            when(it) {
                is LoadState.Success -> btnRefresh.isEnabled = true
                is LoadState.Fail -> {
                    btnRefresh.isEnabled = true
                    Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
                }
                is LoadState.Loading -> {
                    btnRefresh.isEnabled = false
                }
            }
        })

        viewModel.imageData.observe(this, Observer {

            Glide.with(this).load(it[0]).into(imageView1)
            Glide.with(this).load(it[1]).into(imageView2)
            Glide.with(this).load(it[2]).into(imageView3)
        })

        btnRefresh.setOnClickListener { viewModel.getData() }
    }
}