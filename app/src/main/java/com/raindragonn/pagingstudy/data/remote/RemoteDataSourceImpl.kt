package com.raindragonn.pagingstudy.data.remote

import com.raindragonn.pagingstudy.data.model.TrackItem
import com.raindragonn.pagingstudy.data.remote.api.ItunesApi
import com.raindragonn.pagingstudy.data.remote.response.mapToItem

class RemoteDataSourceImpl(
    private val api: ItunesApi
) : RemoteDataSource {
    override suspend fun getTrackItemList(
        limit: Int,
        offset: Int
    ): List<TrackItem> {
        return api.getItunesTrackList(limit, offset).results?.map { it.mapToItem() } ?: emptyList()
    }
}