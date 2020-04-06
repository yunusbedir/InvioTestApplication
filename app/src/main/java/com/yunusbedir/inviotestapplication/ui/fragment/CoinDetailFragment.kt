package com.yunusbedir.inviotestapplication.ui.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmadrosid.svgloader.SvgLoader
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

import com.yunusbedir.inviotestapplication.R
import com.yunusbedir.inviotestapplication.adapter.detail.DetailReyclerViewAdapter
import com.yunusbedir.inviotestapplication.model.Coins
import com.yunusbedir.inviotestapplication.model.Detail
import com.yunusbedir.inviotestapplication.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_coin_detail.*
import kotlinx.android.synthetic.main.item_coin.view.*
import kotlinx.android.synthetic.main.item_coin.view.imgIcon

class CoinDetailFragment(var coin: Coins) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coin_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setViews()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setViews() {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            MainActivity.mFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, ParentFragment())
                ?.commit()
        }

        SvgLoader.pluck()
            .with(MainActivity.mActivity)
            .load(coin.iconUrl, imgIcon)

        tvName.text = coin.name
        tvSymbol.text = coin.symbol
        tvPrice.text = "$" + "%.2f".format(coin.price.toFloat())

        if (coin.change > 0) {
            viewChange.setBackgroundResource(R.drawable.ic_arrow_up)
            tvChange.text = coin.change.toString()
        } else if (coin.change == 0.0) {
            tvChange.text = coin.change.toString()
        } else {
            viewChange.setBackgroundResource(R.drawable.ic_arrow_down)
            tvChange.text = coin.change.toString().removeRange(0, 1)
        }

        setLineChart(coin, lineChart)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        var list = ArrayList<Detail>()
        list.add(Detail("id", coin.id.toString()))
        list.add(Detail("uuid", coin.uuid.toString()))
        list.add(Detail("slug", coin.slug.toString()))
        list.add(Detail("name", coin.name.toString()))
        list.add(Detail("description", coin.description.toString()))
        list.add(Detail("color", coin.color.toString()))
        list.add(Detail("iconType", coin.iconType.toString()))
        list.add(Detail("iconUrl", coin.iconUrl.toString()))
        list.add(Detail("websiteUrl", coin.websiteUrl.toString()))
        coin.socials.forEach {
            list.add(Detail(it.name, it.url))
        }
        coin.links.forEach {
            list.add(Detail(it.name, it.url))
        }
        list.add(Detail("confirmedSupply", coin.confirmedSupply.toString()))
        list.add(Detail("numberOfMarkets", coin.numberOfMarkets.toString()))
        list.add(Detail("numberOfExchanges", coin.numberOfExchanges.toString()))
        list.add(Detail("type", coin.type.toString()))
        list.add(Detail("volume", coin.volume.toString()))
        list.add(Detail("marketCap", coin.marketCap.toString()))
        list.add(Detail("price", coin.price.toString()))
        list.add(Detail("circulatingSupply", coin.circulatingSupply.toString()))
        list.add(Detail("totalSupply", coin.totalSupply.toString()))
        list.add(Detail("approvedSupply", coin.approvedSupply.toString()))
        list.add(Detail("firstSeen", coin.firstSeen.toString()))
        list.add(Detail("change", coin.change.toString()))
        list.add(Detail("rank", coin.rank.toString()))
        list.add(Detail("allTimeHigh", coin.allTimeHigh.toString()))
        list.add(Detail("penalty", coin.penalty.toString()))

        var adapter = DetailReyclerViewAdapter(list)
        rcvDetail.adapter = adapter

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

        //çizginin rengini değiştirmek
        dataSet.color = Color.parseColor(coin.color)
        dataSets.add(dataSet)

        var lineData = LineData(dataSets)
        lineChart.data = lineData

        // Sol alt taraftaki iconu kaldırma
        lineChart.legend.isEnabled = false

        lineChart.axisRight.setDrawLabels(false)


        lineChart.invalidate()

    }


}
