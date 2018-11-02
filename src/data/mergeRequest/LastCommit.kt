package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class LastCommit(

    @field:SerializedName("author")
    val author: Author? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("timestamp")
    val timestamp: String? = null
)