package com.raindragonn.pagingstudy.data.remote.response

import com.google.gson.annotations.SerializedName

/**
 * kotlin Data class file from Json 플러그인을 이용해 만든 Response 객체
 */
data class TrackResponse(
    @SerializedName("resultCount")
    val resultCount: Int?,
    @SerializedName("results")
    val results: List<Track>?
)