package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding
import com.example.livedata.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private lateinit var mainActivityViewModel: MainActivityViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        observableCounter();
        binding.btnCount.setOnClickListener { mainActivityViewModel.generateRandomNumber() }
    }

    private fun observableCounter() {
        mainActivityViewModel.counter.observe(this, Observer {
            binding.tvCount.text = it.toString();
        })
    }
}