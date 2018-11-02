package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class Changes(

	@field:SerializedName("updated_at")
	val updatedAt: List<String?>? = null,

	@field:SerializedName("updated_by_id")
	val updatedById: List<Any?>? = null,

	@field:SerializedName("labels")
	val labels: Labels? = null
)