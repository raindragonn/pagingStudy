package com.raindragonn.pagingstudy.data.remote.api

import com.raindragonn.pagingstudy.data.remote.response.TrackResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesApi {
    companion object {
        const val SEARCH_LIMIT_SIZE = 50
    }
    /**
     * 검색어와 종류는 각각 BrunoMars 및 song 으로 고정,
     * @param limit : 가져올 데이터의 수
     * @param offset: 가져올 데이터의 시작점
     */
    @GET(
        "search?" +
                "term=BrunoMars&" +
                "entity=song&"
    )
    suspend fun getItunesTrackList(
        @Query("limit")
        limit: Int,
        @Query("offset")
        offset: Int
    ): TrackResponse
}