package com.raindragonn.pagingstudy.data.remote

import com.raindragonn.pagingstudy.data.model.TrackItem

interface RemoteDataSource {
    suspend fun getTrackItemList(
        limit: Int,
        offset: Int
    ): List<TrackItem>
}