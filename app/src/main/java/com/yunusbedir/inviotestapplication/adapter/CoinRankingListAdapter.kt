package com.yunusbedir.inviotestapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yunusbedir.inviotestapplication.R
import com.yunusbedir.inviotestapplication.model.Coins


/**
 * Created by YUNUS BEDİR on 5.04.2020.
 */
class CoinRankingListAdapter(val list: List<Coins>, var onClickListener: (position:Int) -> Unit) :
    RecyclerView.Adapter<CoinRankingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinRankingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return CoinRankingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CoinRankingViewHolder, position: Int) {
        holder.bind(list[position]){
            onClickListener(position)
        }
    }
}