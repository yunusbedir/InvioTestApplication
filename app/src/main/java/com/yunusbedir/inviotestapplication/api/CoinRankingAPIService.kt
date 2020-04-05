package com.yunusbedir.inviotestapplication.api

import com.yunusbedir.inviotestapplication.ui.MainActivity.Companion.PACKAGE_NAME
import com.yunusbedir.inviotestapplication.model.BaseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


/**
 * Created by YUNUS BEDİR on 5.04.2020.
 */
interface CoinRankingAPIService {

/*
    offset = sayfalandırma için kullnılan parametre
    limit = bir istekte kaç coin bilgisi geleceğinin limiti

    header'a packageName'i fonksiyonun içinde verdim
    */

    @GET("/v1/public/coins")
    fun getCoinRanking(
        @Header("packageName") packageName: String? = PACKAGE_NAME,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<BaseModel>
}