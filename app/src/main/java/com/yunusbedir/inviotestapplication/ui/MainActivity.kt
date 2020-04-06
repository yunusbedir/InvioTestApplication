package com.yunusbedir.inviotestapplication.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.transition.Fade
import androidx.transition.TransitionInflater
import androidx.transition.TransitionSet
import com.yunusbedir.inviotestapplication.R
import com.yunusbedir.inviotestapplication.ui.fragment.CoinDetailFragment
import com.yunusbedir.inviotestapplication.ui.fragment.ParentFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_coin.*


class MainActivity : AppCompatActivity() {
    companion object {
        var PACKAGE_NAME: String? = null
        const val TAG: String = "MainActivity"
        var mActivity: AppCompatActivity? = null
        const val MOVE_DEFAULT_TIME: Long = 1000
        const val FADE_DEFAULT_TIME: Long = 300

        var mFragmentManager: FragmentManager? = null

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PACKAGE_NAME = packageName
        mActivity = this

        mFragmentManager = supportFragmentManager
        val fragment = ParentFragment()
        val fragmentTransaction = mFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment_container, fragment)
        fragmentTransaction?.commit()

    }

}
