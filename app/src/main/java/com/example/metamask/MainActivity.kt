package com.example.metamask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.metamask.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val tabTitleArray = arrayOf("자산", "활동")
    private lateinit var  binding: ActivityMainBinding
    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeAsUpIndicator(android.R.drawable.ic_menu_sort_by_size)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //Layout 초기화
        drawerLayout = binding.drawerLayout
        navigationView = binding.navigationView

        navigationView.setNavigationItemSelectedListener(this)

        binding.apply {
            viewPager.adapter = ViewAdapter(supportFragmentManager, lifecycle)
            //
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = tabTitleArray[position]
            }.attach()
        }
    }


    // 툴바 메뉴 버튼이 클릭 됐을 때 실행하는 함수
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // 클릭한 툴바 메뉴 아이템 id 마다 다르게 실행하도록 설정
        when(item!!.itemId){
            android.R.id.home->{
                // 햄버거 버튼 클릭시 네비게이션 드로어 열기
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
        when(item.itemId){
            R.id.item_info-> Toast.makeText(this,"menu_item1 실행",Toast.LENGTH_SHORT).show()
            R.id.item_notice-> Toast.makeText(this,"menu_item2 실행",Toast.LENGTH_SHORT).show()
            R.id.item_setting-> Toast.makeText(this,"menu_item3 실행",Toast.LENGTH_SHORT).show()
        }
        return false
    }

}