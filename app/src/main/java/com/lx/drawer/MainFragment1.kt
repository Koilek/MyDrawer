package com.lx.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lx.drawer.databinding.FragmentMain1Binding


class MainFragment1 : Fragment() {
    var _binding: FragmentMain1Binding? = null
    val binding get() = _binding!!

    enum class mainCarouselItem {
       CAROUSEL1, CAROUSEL2, CAROUSEL3
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMain1Binding.inflate(inflater, container, false)
        // 메인 캐러셀 실행
        mainCarouselList()
        return binding.root
    }
    //메인 캐러셀 함수
    fun mainCarouselList() {
        val mainCarouselList = listOf(MainCarouselFragment1(), MainCarouselFragment2(), MainCarouselFragment3())
        val mainCarouselAdapter = MainCarouselPageAdapter(this)
        mainCarouselAdapter.mainCarouselFragments = mainCarouselList
        binding.mainCarouselViewPager.adapter = mainCarouselAdapter


    }

}