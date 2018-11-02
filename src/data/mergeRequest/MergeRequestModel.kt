package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class MergeRequestModel(

    @field:SerializedName("object_attributes")
    val objectAttributes: ObjectAttributes? = null,

    @field:SerializedName("changes")
    val changes: Changes? = null,

    @field:SerializedName("project")
    val project: Project? = null,

    @field:SerializedName("repository")
    val repository: Repository? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("object_kind")
    val objectKind: String? = null,

    @field:SerializedName("labels")
    val labels: List<LabelsItem?>? = null
)