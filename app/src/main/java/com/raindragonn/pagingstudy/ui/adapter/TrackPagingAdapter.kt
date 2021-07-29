package com.raindragonn.pagingstudy.ui.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.raindragonn.pagingstudy.data.model.TrackItem

class TrackPagingAdapter : PagingDataAdapter<TrackItem, TrackViewHolder>(differ) {
    companion object {
        private val differ = object : DiffUtil.ItemCallback<TrackItem>() {
            override fun areItemsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean {
                return oldItem.trackId == newItem.trackId
            }

            override fun areContentsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean {
                return oldItem.trackName == newItem.trackName &&
                        oldItem.artistName == newItem.artistName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        return TrackViewHolder.create(parent)
    }

    override fun onBindViewHolder(holderTrack: TrackViewHolder, position: Int) {
        getItem(position)?.let { trackItem ->
            holderTrack.bind(trackItem)
        }
    }
}