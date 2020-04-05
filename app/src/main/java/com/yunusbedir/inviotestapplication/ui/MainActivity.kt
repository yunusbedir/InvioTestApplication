package com.yunusbedir.inviotestapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.yunusbedir.inviotestapplication.R
import com.yunusbedir.inviotestapplication.api.CoinRankinAPIClient
import com.yunusbedir.inviotestapplication.api.CoinRankingAPIService
import com.yunusbedir.inviotestapplication.model.BaseModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    companion object {
        var PACKAGE_NAME: String? = null
        const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PACKAGE_NAME = packageName
        setRetrofit("","")

    }


    private fun setRetrofit(city: String, province: String) {
        progressBar.visibility = View.VISIBLE

        val service = CoinRankinAPIClient.getInstance()?.create(
            CoinRankingAPIService::class.java
        )

        val call = service?.getCoinRanking(offset = 1, limit = 10)!!
        call.enqueue(object : Callback<BaseModel> {

            override fun onFailure(call: Call<BaseModel>, t: Throwable?) {
                progressBar.visibility = View.GONE
                Log.i(TAG, t.toString())
            }

            override fun onResponse(
                call: Call<BaseModel>,
                response: Response<BaseModel>
            ) {
                if (response.isSuccessful) {
                    Log.i(TAG, response.body().data.coins[0].toString())
                } else {
                    if (response.code() == 429) {
                    }
                    Log.i(TAG, response.code().toString())
                }
                progressBar.visibility = View.GONE
            }
        })
    }
}
