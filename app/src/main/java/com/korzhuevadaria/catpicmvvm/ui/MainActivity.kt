package com.korzhuevadaria.catpicmvvm.ui

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.korzhuevadaria.catpicmvvm.R
import com.korzhuevadaria.catpicmvvm.databinding.ActivityMainBinding
import com.korzhuevadaria.catpicmvvm.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel : MainViewModel by lazy{
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    }
}
