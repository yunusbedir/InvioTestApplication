package com.yunusbedir.inviotestapplication.model

import com.google.gson.annotations.SerializedName


data class Socials (

	@SerializedName("name") val name : String,
	@SerializedName("url") val url : String,
	@SerializedName("type") val type : String
)