package com.korzhuevadaria.catpicmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.korzhuevadaria.catpicmvvm.adapters.PhotoGridAdapter
import com.korzhuevadaria.catpicmvvm.databinding.FragmentListBinding
import com.korzhuevadaria.catpicmvvm.viewmodels.MainViewModel

class ListFragment : Fragment() {
    private val viewModel : MainViewModel by lazy{
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel

        viewModel.photoList.observe(viewLifecycleOwner, Observer {

        })

        binding.photoGrid.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener{
            // TODO: implement navigation
        })

        return binding.root
    }
}