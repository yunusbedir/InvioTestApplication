package com.yunusbedir.inviotestapplication.adapter.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yunusbedir.inviotestapplication.model.Detail


/**
 * Created by YUNUS BEDİR on 6.04.2020.
 */
class DetailReyclerViewAdapter(private val list: List<Detail>) :
    RecyclerView.Adapter<DetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {

        holder.bind(list[position])

    }
}