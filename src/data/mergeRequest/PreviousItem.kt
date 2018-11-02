package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class PreviousItem(

    @field:SerializedName("template")
    val template: Boolean? = null,

    @field:SerializedName("color")
    val color: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("project_id")
    val projectId: Int? = null,

    @field:SerializedName("group_id")
    val groupId: Int? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("type")
    val type: String? = null
)