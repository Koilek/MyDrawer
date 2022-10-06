package com.lx.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lx.drawer.databinding.FragmentMain2Binding

class MainFragment2 : Fragment() {
    var _binding: FragmentMain2Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMain2Binding.inflate(inflater, container, false)

        return binding.root
    }

}