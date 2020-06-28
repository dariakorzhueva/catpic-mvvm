package com.korzhuevadaria.catpicmvvm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.korzhuevadaria.catpicmvvm.databinding.GridViewItemBinding
import com.korzhuevadaria.catpicmvvm.network.PhotoItem

class PhotoGridAdapter(val onClickListener: OnClickListener) :
    ListAdapter<PhotoItem, PhotoGridAdapter.PhotoViewHolder>(DiffCallback) {
    class PhotoViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photoItem: PhotoItem) {
            binding.item = photoItem

            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        return PhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photoItem = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(photoItem)
        }
        holder.bind(photoItem)
    }

    class OnClickListener(val clickListener: (photoItem: PhotoItem) -> Unit) {
        fun onClick(photoItem: PhotoItem) = clickListener(photoItem)
    }
}