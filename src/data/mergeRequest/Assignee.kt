package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class Assignee(

    @field:SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("username")
    val username: String? = null
)