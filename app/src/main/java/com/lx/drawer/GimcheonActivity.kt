package com.lx.drawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.lx.drawer.databinding.ActivityGimcheonBinding
import com.lx.drawer.databinding.ActivitySeoulBinding

class GimcheonActivity : AppCompatActivity() {
    lateinit var binding: ActivityGimcheonBinding
    // 김천게시판 화면 띄우기를 위한 런처 만들기
    val gimcheonBoardLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        showToast("김천 게시판에서 돌아옴")
    }
    enum class GimcheonFragmentItem {
        GIMCHEON1, GIMCHEON2, GIMCHEON3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGimcheonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 메인프래그먼트1 눌렀을 때
        binding.gimcheonButton1.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
            onFragmentChanged(GimcheonActivity.GimcheonFragmentItem.GIMCHEON1)
        }
        // 메인프래그먼트2 눌렀을 떄
        binding.gimcheonButton2.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment()).commit()
            onFragmentChanged(GimcheonActivity.GimcheonFragmentItem.GIMCHEON2)
        }
        //김천 게시판 화면 띄우기
        binding.gimcheonButton3.setOnClickListener {

            val gimcheonboardIntent = Intent(applicationContext, GimcheonBoardActivity::class.java)
            gimcheonBoardLauncher.launch(gimcheonboardIntent)

        }
//        // 메인프래그먼트3 눌렀을 때
//        binding.gimcheonButton3.setOnClickListener {
//            //supportFragmentManager.beginTransaction().replace(R.id.container, ThirdFragment()).commit()
//            onFragmentChanged(GimcheonActivity.GimcheonFragmentItem.GIMCHEON3)
//        }
    }
    fun onFragmentChanged(name: GimcheonActivity.GimcheonFragmentItem){
        when(name){
            GimcheonActivity.GimcheonFragmentItem.GIMCHEON1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.gimcheonFrame, GimcheonFragment1()).commit()
            }
            GimcheonActivity.GimcheonFragmentItem.GIMCHEON2 -> {
                supportFragmentManager.beginTransaction().replace(R.id.gimcheonFrame, GimcheonFragment2()).commit()
            }
            GimcheonActivity.GimcheonFragmentItem.GIMCHEON3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.gimcheonFrame, GimcheonFragment3()).commit()
            }
        }
    }
    fun showToast(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}