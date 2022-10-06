package com.lx.drawer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.lx.drawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var fragment: Fragment

//    // 런처 만들기
//    val menuLauncher =registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult(),
//        ActivityResultCallback {
//            showToast("메뉴화면에서 돌아옴")
//        }
//    )

    // 부분화면 구분자
    enum class MainFragmentItem {
        MAIN, ROULETTE, LOCAL, LOGIN, SIGNUP, NOTICE, RECOMMEND, MODIFY, GOODS
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 첫화면 설정
        //onFragmentChanged(MainFragmentItem.ITEM1)

        // 툴바 설정
        setSupportActionBar(binding.toolbar)

        // 드로어 설정
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // 햄버거 메뉴 추가
        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.main_modify -> {
                    showToast("수정 하고파")
                    onFragmentChanged(MainFragmentItem.MODIFY, null)
                }
                R.id.recommend -> {
                    showToast("추천 하고파")
                    onFragmentChanged(MainFragmentItem.RECOMMEND, null)
                }
                R.id.notice -> {
                    showToast("공지 보고파")
                    onFragmentChanged(MainFragmentItem.NOTICE, null)
                }
                R.id.login -> {
                    showToast("로그인 하고파")
                    onFragmentChanged(MainFragmentItem.LOGIN, null)
                }
                R.id.signup -> {
                    showToast("회원가입 하고파")
                    onFragmentChanged(MainFragmentItem.SIGNUP, null)
                }
                R.id.goods -> {
                    showToast("쇼핑하고파")
                    onFragmentChanged(MainFragmentItem.GOODS, null)
                }
            }

            binding.drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener true
        }

        //하단 네비게이션바 메뉴
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.main_bottom_tab1 -> {
                    onFragmentChanged(MainFragmentItem.ROULETTE, null)
                    binding.toolbar.title = "상품 보고파"
                }
                R.id.main_bottom_tab2 -> {
                    onFragmentChanged(MainFragmentItem.MAIN, null)
                    binding.toolbar.title = "메인 보고파"
                }
                R.id.main_bottom_tab3 -> {
                    onFragmentChanged(MainFragmentItem.LOCAL, null)
                    binding.toolbar.title = "지역 보고파"
                }
            }
            return@setOnNavigationItemSelectedListener true
        }



        onFragmentChanged(MainFragmentItem.MAIN, null)



    }

    // 프래그먼트 메뉴 화면 추가 버튼
    fun onFragmentChanged(item:MainFragmentItem, bundle: Bundle?) {
        var fragment: Fragment
        when(item) {
            MainFragmentItem.MAIN -> {
                binding.toolbar.title = "메인"
                fragment = MainFragment1()
            }
            MainFragmentItem.ROULETTE -> {
                binding.toolbar.title = "룰렛 화면"
                fragment = MainFragment2()
            }
            MainFragmentItem.LOCAL -> {
                binding.toolbar.title = "지역선택 화면"
                fragment = MainFragment3()
            }
            MainFragmentItem.MODIFY -> {
                binding.toolbar.title = "회원정보 수정 화면"
                fragment = ModifyFragment()
            }
            MainFragmentItem.RECOMMEND -> {
                binding.toolbar.title = "지역 추천 화면"
                fragment = RecommendFragment()
            }
            MainFragmentItem.NOTICE -> {
                binding.toolbar.title = "공지 화면 화면"
                fragment = NoticeFragment()
            }
            MainFragmentItem.LOGIN -> {
                binding.toolbar.title = "로그인 화면"
                fragment = LoginFragment()
            }
            MainFragmentItem.SIGNUP -> {
                binding.toolbar.title = "회원가입 화면"
                fragment = SignUpFragment()
            }
                MainFragmentItem.GOODS -> {
                binding.toolbar.title = "쇼핑 화면"
                fragment = GoodsFragment()
            }
        }

        supportFragmentManager.beginTransaction().replace(R.id.mainFrame, fragment).commit()
    }

    // 시스템 BACK 키 눌렀을 때
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    // 토스트 메시지 보여주기
    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}