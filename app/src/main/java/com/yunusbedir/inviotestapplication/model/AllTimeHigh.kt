package com.yunusbedir.inviotestapplication.model

import com.google.gson.annotations.SerializedName


data class AllTimeHigh (

	@SerializedName("price") val price : String,
	@SerializedName("timestamp") val timestamp : Long
)