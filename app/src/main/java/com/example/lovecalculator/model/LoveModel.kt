package com.example.lovecalculator.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoveModel(
    @SerializedName("fname")
    var firstname: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
) : Serializable