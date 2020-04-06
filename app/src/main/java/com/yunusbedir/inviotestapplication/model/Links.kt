package com.yunusbedir.inviotestapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links (

	@SerializedName("name") val name : String,
	@SerializedName("url") val url : String,
	@SerializedName("type") val type : String
) : Parcelable