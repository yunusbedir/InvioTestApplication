package com.yunusbedir.inviotestapplication.model

import com.google.gson.annotations.SerializedName


data class Stats (

	@SerializedName("total") val total : Int,
	@SerializedName("offset") val offset : Int,
	@SerializedName("limit") val limit : Int,
	@SerializedName("order") val order : String,
	@SerializedName("base") val base : String,
	@SerializedName("totalMarkets") val totalMarkets : Double,
	@SerializedName("totalExchanges") val totalExchanges : Double,
	@SerializedName("totalMarketCap") val totalMarketCap : Double,
	@SerializedName("total24hVolume") val total24hVolume : Double
)