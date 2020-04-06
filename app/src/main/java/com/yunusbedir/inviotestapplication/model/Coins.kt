package com.yunusbedir.inviotestapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coins(

    @SerializedName("id") val id: Int,
    @SerializedName("uuid") val uuid: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("color") val color: String,
    @SerializedName("iconType") val iconType: String,
    @SerializedName("iconUrl") val iconUrl: String,
    @SerializedName("websiteUrl") val websiteUrl: String,
    @SerializedName("socials") val socials: List<Socials>,
    @SerializedName("links") val links: List<Links>,
    @SerializedName("confirmedSupply") val confirmedSupply: Boolean,
    @SerializedName("numberOfMarkets") val numberOfMarkets: Int,
    @SerializedName("numberOfExchanges") val numberOfExchanges: Int,
    @SerializedName("type") val type: String,
    @SerializedName("volume") val volume: Long,
    @SerializedName("marketCap") val marketCap: Long,
    @SerializedName("price") val price: String,
    @SerializedName("circulatingSupply") val circulatingSupply: Double,
    @SerializedName("totalSupply") val totalSupply: Double,
    @SerializedName("approvedSupply") val approvedSupply: Boolean,
    @SerializedName("firstSeen") val firstSeen: Long,
    @SerializedName("change") val change: Double,
    @SerializedName("rank") val rank: Int,
    @SerializedName("history") val history: List<String>,
    @SerializedName("allTimeHigh") val allTimeHigh: AllTimeHigh,
    @SerializedName("penalty") val penalty: Boolean
) : Parcelable