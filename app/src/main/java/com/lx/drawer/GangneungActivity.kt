package com.lx.drawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.lx.drawer.databinding.ActivityGangneungBinding
import com.lx.drawer.databinding.ActivityGimcheonBinding

class GangneungActivity : AppCompatActivity() {
    lateinit var binding: ActivityGangneungBinding
    // 강릉게시판 화면 띄우기를 위한 런처 만들기
    val gangneungBoardLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        showToast("강릉 게시판에서 돌아옴")
    }
    enum class GangneungFragmentItem {
        GANGNEUNG1, GANGNEUNG2, GANGNEUNG3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGangneungBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 메인프래그먼트1 눌렀을 때
        binding.gangneunButton1.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
            onFragmentChanged(GangneungActivity.GangneungFragmentItem.GANGNEUNG1)
        }
        // 메인프래그먼트2 눌렀을 떄
        binding.gangneunButton2.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment()).commit()
            onFragmentChanged(GangneungActivity.GangneungFragmentItem.GANGNEUNG2)
        }
        //강릉 게시판 화면 띄우기
        binding.gangneunButton3.setOnClickListener {

            val gangneungboardIntent = Intent(applicationContext, GangneungBoardActivity::class.java)
            gangneungBoardLauncher.launch(gangneungboardIntent)

        }
//        // 메인프래그먼트3 눌렀을 때
//        binding.gangneunButton3.setOnClickListener {
//            //supportFragmentManager.beginTransaction().replace(R.id.container, ThirdFragment()).commit()
//            onFragmentChanged(GangneungActivity.GangneungFragmentItem.GANGNEUNG3)
//        }
    }
    fun onFragmentChanged(name: GangneungActivity.GangneungFragmentItem){
        when(name){
            GangneungActivity.GangneungFragmentItem.GANGNEUNG1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.gangneungFrame, GangneungFragment1()).commit()
            }
            GangneungActivity.GangneungFragmentItem.GANGNEUNG2 -> {
                supportFragmentManager.beginTransaction().replace(R.id.gangneungFrame, GangneungFragment2()).commit()
            }
            GangneungActivity.GangneungFragmentItem.GANGNEUNG3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.gangneungFrame, GangneungFragment3()).commit()
            }
        }
    }
    fun showToast(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}