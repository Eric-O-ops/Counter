package com.geektech.counter.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.geektech.counter.MainViewModel
import com.geektech.counter.R
import com.geektech.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupObserve()
        setPlus()
        setMinus()


    }

    private fun setupObserve() {
        viewModel?.data?.observe(this){
            binding.counter.text = it.toString()
            if (it >= 10){
                binding.counter.setTextColor(Color.GREEN)

            }else{
                binding.counter.setTextColor(Color.BLACK)

            }
        }
    }

    private fun setPlus() {
        binding.plus.setOnClickListener {
            viewModel?.plus()

        }
    }

    private fun setMinus() {
        binding.minus.setOnClickListener {
            viewModel?.minus()

        }
    }
}