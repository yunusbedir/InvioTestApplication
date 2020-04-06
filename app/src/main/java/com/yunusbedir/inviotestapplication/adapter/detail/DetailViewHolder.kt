package com.yunusbedir.inviotestapplication.adapter.detail

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yunusbedir.inviotestapplication.R
import com.yunusbedir.inviotestapplication.model.Detail
import kotlinx.android.synthetic.main.item_detail.view.*


/**
 * Created by YUNUS BEDİR on 6.04.2020.
 */
class DetailViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false)
) {

    fun bind(detail: Detail) {
        itemView.tvTitle.text = detail.title
        itemView.tvValue.text = detail.value
    }
}