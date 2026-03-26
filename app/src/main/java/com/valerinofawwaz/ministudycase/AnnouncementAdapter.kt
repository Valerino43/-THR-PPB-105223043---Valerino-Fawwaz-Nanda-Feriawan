package com.valerinofawwaz.ministudycase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.valerinofawwaz.ministudycase.databinding.ItemAnnouncementBinding

class AnnouncementAdapter(private val onItemClick: (Announcement) -> Unit) :
    ListAdapter<Announcement, AnnouncementAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private val binding: ItemAnnouncementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(announcement: Announcement, onItemClick: (Announcement) -> Unit) {
            binding.tvTitle.text = announcement.title
            binding.tvDate.text = announcement.date
            binding.tvCategory.text = announcement.category
            binding.root.setOnClickListener { onItemClick(announcement) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnnouncementBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Announcement>() {
        override fun areItemsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
            return oldItem == newItem
        }
    }
}