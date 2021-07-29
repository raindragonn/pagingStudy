package com.raindragonn.pagingstudy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raindragonn.pagingstudy.data.model.TrackItem
import com.raindragonn.pagingstudy.databinding.ItemTrackBinding

class TrackViewHolder(
    private val binding: ItemTrackBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            parent: ViewGroup
        ): TrackViewHolder {
            val binding = ItemTrackBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return TrackViewHolder(binding)
        }
    }

    fun bind(track: TrackItem) {
        binding.trackItem = track
    }
}