package com.example.data.mergeRequest

import com.google.gson.annotations.SerializedName

data class Target(

    @field:SerializedName("path_with_namespace")
    val pathWithNamespace: String? = null,

    @field:SerializedName("ssh_url")
    val sshUrl: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("git_http_url")
    val gitHttpUrl: String? = null,

    @field:SerializedName("git_ssh_url")
    val gitSshUrl: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("http_url")
    val httpUrl: String? = null,

    @field:SerializedName("web_url")
    val webUrl: String? = null,

    @field:SerializedName("avatar_url")
    val avatarUrl: Any? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("namespace")
    val namespace: String? = null,

    @field:SerializedName("visibility_level")
    val visibilityLevel: Int? = null,

    @field:SerializedName("default_branch")
    val defaultBranch: String? = null,

    @field:SerializedName("homepage")
    val homepage: String? = null
)