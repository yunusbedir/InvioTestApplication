package com.yunusbedir.inviotestapplication.model

import com.google.gson.annotations.SerializedName



data class Base (

	@SerializedName("symbol") val symbol : String,
	@SerializedName("sign") val sign : String
)