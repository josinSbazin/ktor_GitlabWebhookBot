package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class ObjectAttributes(

    @field:SerializedName("work_in_progress")
    val workInProgress: Boolean? = null,

    @field:SerializedName("last_commit")
    val lastCommit: LastCommit? = null,

    @field:SerializedName("iid")
    val iid: Int? = null,

    @field:SerializedName("milestone_id")
    val milestoneId: Any? = null,

    @field:SerializedName("target_branch")
    val targetBranch: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("source_project_id")
    val sourceProjectId: Int? = null,

    @field:SerializedName("source")
    val source: Source? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("source_branch")
    val sourceBranch: String? = null,

    @field:SerializedName("target")
    val target: Target? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("merge_status")
    val mergeStatus: String? = null,

    @field:SerializedName("action")
    val action: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("state")
    val state: String? = null,

    @field:SerializedName("assignee")
    val assignee: Assignee? = null,

    @field:SerializedName("author_id")
    val authorId: Int? = null,

    @field:SerializedName("target_project_id")
    val targetProjectId: Int? = null,

    @field:SerializedName("assignee_id")
    val assigneeId: Int? = null
)