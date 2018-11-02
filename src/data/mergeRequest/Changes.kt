package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class Changes(

    @field:SerializedName("updated_by_id")
    val updatedById: List<Long?> = emptyList(),

    //todo разобраться
//    @field:SerializedName("updated_at")
//    val updatedAt: List<String?> = emptyList(),

    @field:SerializedName("labels")
	val labels: Labels? = null
)