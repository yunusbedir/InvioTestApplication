package com.yunusbedir.inviotestapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.yunusbedir.inviotestapplication.R
import com.yunusbedir.inviotestapplication.adapter.CoinRankingListAdapter
import com.yunusbedir.inviotestapplication.api.CoinRankinAPIClient
import com.yunusbedir.inviotestapplication.api.CoinRankingAPIService
import com.yunusbedir.inviotestapplication.model.BaseModel
import com.yunusbedir.inviotestapplication.ui.fragment.ParentFragment
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    companion object {
        var PACKAGE_NAME: String? = null
        const val TAG: String = "MainActivity"
        var mActivity: AppCompatActivity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PACKAGE_NAME = packageName
        mActivity = this

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = ParentFragment()
        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }

}
