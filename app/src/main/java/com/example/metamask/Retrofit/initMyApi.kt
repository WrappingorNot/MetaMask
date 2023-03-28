package com.example.metamask.Retrofit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface initMyApi {
    //@통신 방식 ("통신API명")
    //전체 마켓 조회하인
    @Headers("Accept: application/json", "Cache-Control:max-age=640000")
    @GET("v1/market/all")
    open fun getMarketResponse(): retrofit2.Call<MutableList<accountResponse?>?>?
    @Headers("Accept: application/json", "Cache-Control:max-age=640000")
    @GET("v1/ticker")
    open fun getPriceResponse(
        @Query("markets") markets: String? = null
    ): retrofit2.Call<MutableList<priceResponse?>?>?


}