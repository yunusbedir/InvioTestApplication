package com.yunusbedir.inviotestapplication.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.yunusbedir.inviotestapplication.R
import com.yunusbedir.inviotestapplication.model.Coins
import com.yunusbedir.inviotestapplication.ui.MainActivity
import kotlinx.android.synthetic.main.item_coin.view.*


/**
 * Created by YUNUS BEDİR on 5.04.2020.
 */
class CoinRankingViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    @SuppressLint("SetTextI18n")
    fun bind(coin: Coins, onClick: () -> Unit) {
        view.apply {
            tvName.text = coin.name
            tvSymbol.text = coin.symbol

            if (coin.change > 0) {
                viewChange.setBackgroundResource(R.drawable.ic_arrow_up)
                tvChange.text = coin.change.toString()
            } else if (coin.change == 0.0) {
                tvChange.text = coin.change.toString()
            } else {
                viewChange.setBackgroundResource(R.drawable.ic_arrow_down)
                tvChange.text = coin.change.toString().removeRange(0, 1)
            }
            tvPrice.text = "$" + "%.2f".format(coin.price.toFloat())

            SvgLoader.pluck()
                .with(MainActivity.mActivity)
                .load(coin.iconUrl, imgIcon)

            setOnClickListener {
                onClick()
            }
            setLineChart(coin, lineChart)
        }
    }

    private fun setLineChart(
        coin: Coins,
        lineChart: LineChart
    ) {
        val listHistory = ArrayList<Entry>()
        var i = 0f
        coin.history.forEach {
            listHistory.add(Entry(i, it.toFloat()))
            i++
        }

        val dataSet = LineDataSet(listHistory, "")
        val dataSets = ArrayList<ILineDataSet>()

        //değerleri gizlemek
        dataSet.setDrawValues(false)

        //değerlerin üstündeki yuvarlakları kaldırma
        dataSet.setDrawCircles(false)

        //çizginin rengini değiştirmek
        dataSet.color = Color.parseColor(coin.color)
        dataSets.add(dataSet)

        var lineData = LineData(dataSets)
        lineChart.data = lineData

        // Sol alt taraftaki iconu kaldırma
        lineChart.legend.isEnabled = false

        //grafikteki değer başlılarını gizleme
        lineChart.xAxis.setDrawLabels(false)
        lineChart.axisLeft.setDrawLabels(false)
        lineChart.axisRight.setDrawLabels(false)

        //background daki ızgarayı kaldırma
        lineChart.xAxis.setDrawGridLines(false)
        lineChart.axisLeft.setDrawGridLines(false)
        lineChart.axisRight.setDrawGridLines(false)

        //background daki kenarlıkları kaldırma
        lineChart.xAxis.setDrawAxisLine(false)
        lineChart.axisRight.setDrawAxisLine(false)
        lineChart.axisLeft.setDrawAxisLine(false)

        //açıklamayı gizleme
        lineChart.description.isEnabled = false

        lineChart.invalidate()

    }


}