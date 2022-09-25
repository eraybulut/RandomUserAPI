package com.eray.randomuserapi.model

import com.google.gson.annotations.SerializedName

data class Location (
    @SerializedName("city")
    var city:String,
    @SerializedName("country")
    var country:String,
    @SerializedName("state")
    var state:String
    )