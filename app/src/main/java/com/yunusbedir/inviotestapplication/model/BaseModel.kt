package com.yunusbedir.inviotestapplication.model

import com.google.gson.annotations.SerializedName


data class BaseModel (

	@SerializedName("status") val status : String,
	@SerializedName("data") val data : Data
)