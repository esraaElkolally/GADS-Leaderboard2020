package com.esraa.gadsleaderboard.data.entities
import com.google.gson.annotations.SerializedName
  data class LeadersModel(
    @SerializedName("name") val name: String,
    @SerializedName("numValue",alternate = ["hours","score"]) val numValue: Int,
    @SerializedName("country") val country: String,
    @SerializedName("badgeUrl") val badgeUrl: String
)