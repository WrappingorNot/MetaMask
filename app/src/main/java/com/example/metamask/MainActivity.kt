package com.example.metamask

import android.content.ClipData
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.text.ClipboardManager
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.metamask.adapters.CustomDialog
import com.example.metamask.adapters.ViewHolder
import com.example.metamask.adapters.ViewHolderNetwork
import com.example.metamask.databinding.ActivityMainBinding
import com.example.metamask.dataclasses.Dataclass
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
        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.baseline_dehaze_24)
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
        //스왑화면으로 인텐트
        binding.floatingActionButton3.setOnClickListener {
            val intent = Intent(this, SwapActivity::class.java)
            startActivity(intent)
        }


        //클립보드 복사
        binding.textCopy.setOnClickListener(View.OnClickListener {
            val text: String = binding.textCopy.text.toString()

            createClipData(text)
        })
        //Network Dialog 화면 띄우기
        val dialog = CustomDialog(this)
        binding.networkList.setOnClickListener(View.OnClickListener {

            //리사이클러 뷰 사용
//            var popupMenu= PopupMenu
///
            dialog.myDig()
        })

        //account 화면 bottomdialog 띄우기
        binding.accountBtn.setOnClickListener(View.OnClickListener {
            val bottomdialog = BottomDialog()



            bottomdialog.show(supportFragmentManager, bottomdialog.tag)
        })
    }

    private fun createClipData(message: String){
        // 클립 보드 시스템 가져오기
        val clipboardManager =
        getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager

        val clipData: ClipData = ClipData.newPlainText("message", message)
        clipboardManager.setPrimaryClip(clipData)


        Toast.makeText(this, "복사되었습니다.", Toast.LENGTH_SHORT).show()
    }

    // 툴바 메뉴 버튼이 클릭 됐을 때 실행하는 함수
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item!!.itemId){
            android.R.id.home->{
                // 세줄 버튼 클릭시 네비게이션 드로어 열기
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
        when(item.itemId){
            //R.id.item_info-> Toast.makeText(this,"menu_item1 실행",Toast.LENGTH_SHORT).show()
            //R.id.item_notice-> Toast.makeText(this,"menu_item2 실행",Toast.LENGTH_SHORT).show()
            //R.id.item_setting-> Toast.makeText(this,"menu_item3 실행",Toast.LENGTH_SHORT).show()
        }
        return false
    }

}