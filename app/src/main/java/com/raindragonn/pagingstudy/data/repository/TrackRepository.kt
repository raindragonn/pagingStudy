package com.raindragonn.pagingstudy.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.raindragonn.pagingstudy.data.model.TrackItem

interface TrackRepository {
    fun getTrackList(): LiveData<PagingData<TrackItem>>
}