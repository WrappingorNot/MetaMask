package com.example.metamask

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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
import retrofit2.http.Body

class SwapActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySwapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMarket()
        getPrice()


        binding.coinSelect1.setOnClickListener(View.OnClickListener {
            val bottomdialog = SwapBottomdialog()

            bottomdialog.show(supportFragmentManager, bottomdialog.tag)
        })

    }


    fun getMarket(){
        //로그를 보기위한 Intercepter
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

        initMyApi.getMarketResponse()?.enqueue(object :
            retrofit2.Callback<MutableList<accountResponse?>?> {
            override fun onResponse(
                call: Call<MutableList<accountResponse?>?>,
                response: Response<MutableList<accountResponse?>?>
            ) {
                var result : MutableList<accountResponse?>? = response.body()

                Log.d("123", result?.get(0)?.korean_name.toString())
            }

            override fun onFailure(call: Call<MutableList<accountResponse?>?>, t: Throwable) {
            }
        })
    }
    fun getPrice(){
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
        val market: String = "KRW-ETH"
        initMyApi.getPriceResponse(markets = market)?.enqueue(object :
            retrofit2.Callback<MutableList<priceResponse?>?> {
            override fun onResponse(
                call: Call<MutableList<priceResponse?>?>,
                response: Response<MutableList<priceResponse?>?>
            ) {
                var result : MutableList<priceResponse?>? = response.body()

                Log.d("123", result?.get(0)?.trade_price.toString())

            }

            override fun onFailure(call: Call<MutableList<priceResponse?>?>, t: Throwable) {
            }
        })
    }
}