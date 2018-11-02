package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class Repository(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("homepage")
    val homepage: String? = null
)