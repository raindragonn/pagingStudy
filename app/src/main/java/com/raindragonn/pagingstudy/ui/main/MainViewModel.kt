package com.raindragonn.pagingstudy.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.raindragonn.pagingstudy.data.model.TrackItem
import com.raindragonn.pagingstudy.data.repository.TrackRepository

class MainViewModel(
    repository: TrackRepository
) : ViewModel() {

    private val _trackList: MutableLiveData<PagingData<TrackItem>> =
        repository.getTrackList() as MutableLiveData<PagingData<TrackItem>>

    val trackList: LiveData<PagingData<TrackItem>>
        get() = _trackList
}