package com.eray.randomuserapi.model

import com.google.gson.annotations.SerializedName

data class UserResponse (

    @SerializedName("results")
    var userList:List<Results>

        )