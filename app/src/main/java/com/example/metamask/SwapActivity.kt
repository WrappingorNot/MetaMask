package com.example.metamask

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.metamask.Retrofit.accountResponse
import com.example.metamask.Retrofit.initMyApi
import com.example.metamask.Retrofit.priceResponse
import com.example.metamask.databinding.ActivitySwapBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SwapActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySwapBinding
    private lateinit var adapter: SwapBottomdialogAdapter
    private lateinit var bottomdialog: SwapBottomdialog
    private var list_market = mutableListOf<BottomDialogItem>()
    private val filteredList = mutableListOf<BottomDialogItem>()
    private var exchangerate: Int = 0

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list_market = ArrayList<BottomDialogItem>()

        val adapter = SwapBottomdialogAdapter()


        val interceptor1 = HttpLoggingInterceptor()
        interceptor1.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor1)
            .build()
        //retrofit설정
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.upbit.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client) //로그 기능
            .build()
        var initMyApi = retrofit.create(initMyApi::class.java)





        //종목들 조회후 가져와서  recyclerView에 담기

        initMyApi.getMarketResponse()?.enqueue(object :
            retrofit2.Callback<MutableList<accountResponse?>?> {
            override fun onResponse(
                call: Call<MutableList<accountResponse?>?>,
                response: Response<MutableList<accountResponse?>?>
            ) {
                var result : MutableList<accountResponse?>? = response.body()

                Log.d("123", result?.get(0)?.korean_name.toString())
                for (i in 0 until result?.size!!){
                    list_market.add(BottomDialogItem (result?.get(i)?.market.toString()))
                    filteredList.add(BottomDialogItem (result?.get(i)?.market.toString()))
                }
                adapter.setItem(list_market)

            }

            override fun onFailure(call: Call<MutableList<accountResponse?>?>, t: Throwable) {
            }
        })

        //가격 가져오기
        val market: String = "KRW-ETH"
        initMyApi.getPriceResponse(markets = market)?.enqueue(object :
            retrofit2.Callback<MutableList<priceResponse?>?> {
            override fun onResponse(
                call: Call<MutableList<priceResponse?>?>,
                response: Response<MutableList<priceResponse?>?>
            ) {
                var result : MutableList<priceResponse?>? = response.body()
                exchangerate = result?.get(0)?.trade_price?.toInt() ?:
                        Log.d("123", result?.get(0)?.trade_price.toString())
                binding.tvExchange.text = "변환 후 :"+ 0 + "원"

            }

            override fun onFailure(call: Call<MutableList<priceResponse?>?>, t: Throwable) {
            }
        })
        binding.btnExchange.setOnClickListener(View.OnClickListener {
            binding.tvExchange.text = "변환 후 :"+ exchangerate*(Integer.parseInt(binding.moneyExchange.text.toString())) + "원"
        })





        val bottomdialog = SwapBottomdialog(adapter)

        binding.coinSelect1.setOnClickListener(View.OnClickListener {



            bottomdialog.show(supportFragmentManager, bottomdialog.tag)

            
        })
        val searchview = bottomdialog.view?.findViewById<SearchView>(R.id.search_view)

        searchview?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {


                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {

                filteredList.clear()
                ( 0 until list_market.size)?.filter{
                    list_market[it].toString().toLowerCase().contains(newText.toLowerCase())
                }?.mapTo(filteredList) { list_market[it] }

                var adapter1 = SwapBottomdialogAdapter()
                adapter1.setItem(filteredList)
                return false
            }
        })

        binding.coinSelect2.setOnClickListener(View.OnClickListener {


            bottomdialog.show(supportFragmentManager, bottomdialog.tag)

        })

        getPrice()

    }




    fun getMarket( list_market: ArrayList<BottomDialogItem>){
        //로그를 보기위한 Intercepter

    }
    fun getPrice() {
        val interceptor1 = HttpLoggingInterceptor()
        interceptor1.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor1)
            .build()
        //retrofit설정
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.upbit.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client) //로그 기능
            .build()
        var initMyApi = retrofit.create(initMyApi::class.java)

    }
}