package com.yunusbedir.inviotestapplication.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.yunusbedir.inviotestapplication.R
import com.yunusbedir.inviotestapplication.model.Coins
import com.yunusbedir.inviotestapplication.ui.MainActivity
import kotlinx.android.synthetic.main.item_coin.view.*


/**
 * Created by YUNUS BEDİR on 5.04.2020.
 */
class CoinRankingViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    fun bind(coin: Coins, onClick: () -> Unit) {
        view.apply {
            tvName.text = coin.name
            tvSymbol.text = coin.symbol

            if (coin.change > 0) {
                viewChange.setBackgroundResource(R.drawable.ic_arrow_up)
                tvChange.text = coin.change.toString()
            } else {
                viewChange.setBackgroundResource(R.drawable.ic_arrow_down)
                tvChange.text = coin.change.toString().removeRange(0..1)
            }
            tvPrice.text = coin.price
            tvMarketCap.text = coin.marketCap.toString()

            SvgLoader.pluck()
                .with(MainActivity.mActivity)
                .load(coin.iconUrl, imgIcon)

            setOnClickListener {
                onClick()
            }
        }
    }
}