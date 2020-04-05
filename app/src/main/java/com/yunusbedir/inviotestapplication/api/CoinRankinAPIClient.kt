package com.yunusbedir.inviotestapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by YUNUS BEDİR on 5.04.2020.
 */
object CoinRankinAPIClient {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://api.coinranking.com"

    fun getInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}