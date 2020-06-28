package com.korzhuevadaria.catpicmvvm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.korzhuevadaria.catpicmvvm.databinding.GridViewItemBinding
import com.korzhuevadaria.catpicmvvm.models.CatItem

class PhotoGridAdapter(val onClickListener: OnClickListener) :
    ListAdapter<CatItem, PhotoGridAdapter.PhotoViewHolder>(DiffCallback) {
    class PhotoViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catItem: CatItem) {
            binding.item = catItem

            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CatItem>() {
        override fun areItemsTheSame(oldItem: CatItem, newItem: CatItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CatItem, newItem: CatItem): Boolean {
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

    class OnClickListener(val clickListener: (photoItem: CatItem) -> Unit) {
        fun onClick(photoItem: CatItem) = clickListener(photoItem)
    }
}