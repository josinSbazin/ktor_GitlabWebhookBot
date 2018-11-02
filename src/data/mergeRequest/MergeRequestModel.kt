package com.example.data.mergeRequest

data class MergeRequestModel(
    val objectAttributes: ObjectAttributes? = null,
    val changes: Changes? = null,
    val project: Project? = null,
    val repository: Repository? = null,
    val user: User? = null,
    val objectKind: String? = null,
    val labels: List<LabelsItem?>? = null
)
