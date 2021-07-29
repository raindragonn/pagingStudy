package com.raindragonn.pagingstudy.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.raindragonn.pagingstudy.data.pagingSource.ItunesPagingSource
import com.raindragonn.pagingstudy.data.model.TrackItem
import com.raindragonn.pagingstudy.data.remote.RemoteDataSource
import com.raindragonn.pagingstudy.data.remote.api.ItunesApi.Companion.SEARCH_LIMIT_SIZE

class TrackRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : TrackRepository {

    override fun getTrackList(): LiveData<PagingData<TrackItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = SEARCH_LIMIT_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ItunesPagingSource(remoteDataSource)
            }
        ).liveData
    }
}