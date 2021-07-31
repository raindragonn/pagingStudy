package com.raindragonn.pagingstudy.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.raindragonn.pagingstudy.R
import com.raindragonn.pagingstudy.databinding.ActivityMainBinding
import com.raindragonn.pagingstudy.ui.adapter.TrackPagingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    private val viewModel: MainViewModel by viewModel()
    private val adapter = TrackPagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        initRecyclerView()
        onObserve()
    }

    private fun initRecyclerView() {
        binding.rv.adapter = adapter
    }

    private fun onObserve() {
        viewModel.trackList.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}