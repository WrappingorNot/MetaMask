package com.example.metamask.Retrofit

import retrofit2.http.GET
import retrofit2.http.Headers

interface initMyApi {
    //@통신 방식 ("통신API명")
    //전체 마켓 조회하기
    @Headers("Accept: application/json", "Cache-Control:max-age=640000")
    @GET("v1/market/all")
    open fun getMarketResponse(): retrofit2.Call<MutableList<accountResponse?>?>?


}