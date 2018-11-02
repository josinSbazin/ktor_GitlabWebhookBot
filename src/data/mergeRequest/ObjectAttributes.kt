package com.example.data.mergeRequest

data class ObjectAttributes(
    val workInProgress: Boolean? = null,
    val lastCommit: LastCommit? = null,
    val iid: Int? = null,
    val milestoneId: Any? = null,
    val targetBranch: String? = null,
    val createdAt: String? = null,
    val description: String? = null,
    val sourceProjectId: Int? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null,
    val sourceBranch: String? = null,
    val target: Target? = null,
    val updatedAt: String? = null,
    val mergeStatus: String? = null,
    val action: String? = null,
    val id: Int? = null,
    val state: String? = null,
    val assignee: Assignee? = null,
    val authorId: Int? = null,
    val targetProjectId: Int? = null,
    val assigneeId: Int? = null
)
