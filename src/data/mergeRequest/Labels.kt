package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class Labels(

    @field:SerializedName("current")
    val current: List<CurrentItem?> = emptyList(),

    @field:SerializedName("previous")
    val previous: List<PreviousItem?> = emptyList()
)