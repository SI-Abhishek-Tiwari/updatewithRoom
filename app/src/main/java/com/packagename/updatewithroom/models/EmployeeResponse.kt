package com.packagename.updatewithroom.models


import com.google.gson.annotations.SerializedName

data class EmployeeResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)