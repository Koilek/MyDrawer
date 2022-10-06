package com.lx.drawer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.lx.drawer.databinding.FragmentMain3Binding

class MainFragment3 : Fragment() {
    var _binding: FragmentMain3Binding? = null
    val binding get() = _binding!!

    // 서울 화면 띄우기를 위한 런처
    val seoulLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        showToast("서울에서 돌아옴")
    }
    // 김천 화면 띄우기를 위한 런처
    val gimcheonLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        showToast("김천에서 돌아옴")
    }
    // 강릉 화면 띄우기를 위한 런처
    val gangneungLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        showToast("강릉에서 돌아옴")
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMain3Binding.inflate(inflater, container, false)
        binding.seoulButton.setOnClickListener {
            val seoulIntent= Intent(getActivity(), SeoulActivity::class.java)
            startActivity(seoulIntent)
        }
        binding.gimcheonButton.setOnClickListener {
            val gimcheonIntent= Intent(getActivity(), GimcheonActivity::class.java)
            startActivity(gimcheonIntent)
        }
        binding.gangneungButton.setOnClickListener {
            val GangneungIntent= Intent(getActivity(), GangneungActivity::class.java)
            startActivity(GangneungIntent)
        }

        return binding.root
    }

    fun showToast(message: String) {
        Toast.makeText(context,message, Toast.LENGTH_LONG).show()
    }

}