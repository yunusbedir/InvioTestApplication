package com.yunusbedir.inviotestapplication.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ahmadrosid.svgloader.SvgLoader
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.yunusbedir.inviotestapplication.R
import com.yunusbedir.inviotestapplication.adapter.CoinRankingListAdapter
import com.yunusbedir.inviotestapplication.api.CoinRankinAPIClient
import com.yunusbedir.inviotestapplication.api.CoinRankingAPIService
import com.yunusbedir.inviotestapplication.model.BaseModel
import com.yunusbedir.inviotestapplication.model.Coins
import com.yunusbedir.inviotestapplication.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_parent.*
import kotlinx.android.synthetic.main.item_coin.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ParentFragment : Fragment() {

    companion object {
        var offset: Int = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_parent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listeners()

        tvOffset.text = offset.toString()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun listeners() {
        viewPrevious.setOnClickListener {
            if (offset > 1) {
                offset--
                tvOffset.text = offset.toString()
            }
        }
        viewNext.setOnClickListener {
            if (offset < 4) {
                offset++
                tvOffset.text = offset.toString()
            }
        }

        tvOffset.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setRetrofit(offset - 1)
            }

        })
    }


    private fun setRetrofit(offset: Int) {
        progressBar.visibility = View.VISIBLE

        val service = CoinRankinAPIClient.getInstance()?.create(
            CoinRankingAPIService::class.java
        )

        val call = service?.getCoinRanking(offset = offset, limit = 10)!!
        call.enqueue(object : Callback<BaseModel> {

            override fun onFailure(call: Call<BaseModel>, t: Throwable?) {
                progressBar.visibility = View.GONE
                Log.i(MainActivity.TAG, t.toString())
            }

            override fun onResponse(
                call: Call<BaseModel>,
                response: Response<BaseModel>
            ) {
                if (response.isSuccessful) {
                    setRecyclerView(response.body()!!.data.coins)
                    setChartCoins(response.body()!!.data.coins)
                } else {
                    Log.i(MainActivity.TAG, response.code().toString())
                }
                progressBar.visibility = View.GONE
            }
        })
    }

    private fun setRecyclerView(listCoins: List<Coins>) {
        val adapter = CoinRankingListAdapter(listCoins) {}
        rcvListCoins.adapter = adapter
    }


    private fun setChartCoins(listCoins: List<Coins>) {
        val dataVals = ArrayList<BarEntry>()
        var i = 0f
        listCoins.forEach {
            dataVals.add(BarEntry(i, it.price))
            i++
        }

        val dataSet1 = BarDataSet(dataVals, "DataSet 1")
        val barData = BarData()
        barData.addDataSet(dataSet1)

        barChart.data = barData
        barChart.invalidate()

    }

    private fun BarEntry(index: Float, value: String): BarEntry {
        return BarEntry(index, value.toFloat())

    }


}
