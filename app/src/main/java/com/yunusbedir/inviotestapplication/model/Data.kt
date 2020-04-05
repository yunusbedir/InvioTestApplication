package com.yunusbedir.inviotestapplication.model

import com.google.gson.annotations.SerializedName



data class Data (

	@SerializedName("stats") val stats : Stats,
	@SerializedName("base") val base : Base,
	@SerializedName("coins") val coins : List<Coins>
)