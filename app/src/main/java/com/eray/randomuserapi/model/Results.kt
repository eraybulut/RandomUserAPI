package com.eray.randomuserapi.model

import com.google.gson.annotations.SerializedName

data class Results (
    @SerializedName("gender")
    var gender :String,

    @SerializedName("name")
    var name:Name,

    @SerializedName("location")
    var location:Location,

    @SerializedName("email")
    var eMail:String,

    @SerializedName("picture")
    var picture:Picture,

    @SerializedName("phone")
    var phone:String





        )
