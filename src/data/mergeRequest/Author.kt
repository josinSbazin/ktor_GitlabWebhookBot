package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class Author(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)