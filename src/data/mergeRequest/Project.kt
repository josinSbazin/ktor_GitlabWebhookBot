package com.example.data.mergeRequest

data class Project(
    val pathWithNamespace: String? = null,
    val sshUrl: String? = null,
    val description: String? = null,
    val gitHttpUrl: String? = null,
    val gitSshUrl: String? = null,
    val url: String? = null,
    val httpUrl: String? = null,
    val webUrl: String? = null,
    val avatarUrl: Any? = null,
    val name: String? = null,
    val namespace: String? = null,
    val visibilityLevel: Int? = null,
    val defaultBranch: String? = null,
    val id: Int? = null,
    val homepage: String? = null
)
