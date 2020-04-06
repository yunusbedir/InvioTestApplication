package com.yunusbedir.inviotestapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllTimeHigh (

	@SerializedName("price") val price : String,
	@SerializedName("timestamp") val timestamp : Long
) : Parcelable