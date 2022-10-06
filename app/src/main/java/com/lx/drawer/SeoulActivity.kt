package com.lx.drawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.lx.drawer.databinding.ActivitySeoulBinding

class SeoulActivity : AppCompatActivity() {
    // 서울게시판 화면 띄우기를 위한 런처 만들기
    val seoulBoardLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        showToast("서울 게시판에서 돌아옴")
    }
    lateinit var binding: ActivitySeoulBinding
    enum class SeoulFragmentItem {
        SEOUL1, SEOUL2, SEOUL3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeoulBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 메인프래그먼트1 눌렀을 때
        binding.seoulButton1.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
            onFragmentChanged(SeoulFragmentItem.SEOUL1)
        }
        // 메인프래그먼트2 눌렀을 떄
        binding.seoulButton2.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment()).commit()
            onFragmentChanged(SeoulFragmentItem.SEOUL2)
        }
        //서울 게시판 화면 띄우기
        binding.seoulButton3.setOnClickListener {

            val seoulboardIntent = Intent(applicationContext, SeoulBoardActivity::class.java)
            seoulBoardLauncher.launch(seoulboardIntent)

        }

//        // 메인프래그먼트3 눌렀을 때
//        binding.seoulButton3.setOnClickListener {
//            //supportFragmentManager.beginTransaction().replace(R.id.container, ThirdFragment()).commit()
//            onFragmentChanged(SeoulFragmentItem.SEOUL3)
//        }
    }
    fun onFragmentChanged(name:SeoulFragmentItem){
        when(name){
            SeoulFragmentItem.SEOUL1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.seoulFrame, SeoulFragment1()).commit()
            }
            SeoulFragmentItem.SEOUL2 -> {
                supportFragmentManager.beginTransaction().replace(R.id.seoulFrame, SeoulFragment2()).commit()
            }
            SeoulFragmentItem.SEOUL3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.seoulFrame, SeoulFragment3()).commit()
            }
        }
    }
    fun showToast(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}