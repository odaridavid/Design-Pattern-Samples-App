/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.designpatterns.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.odaridavid.designpatterns.databinding.ItemLibraryBinding
import com.mikepenz.aboutlibraries.entity.Library


class LibrariesAdapter(val onClick: (String) -> Unit) :
    ListAdapter<Library, LibrariesAdapter.LicenseViewHolder>(DiffUtil) {

    override fun onBindViewHolder(holder: LicenseViewHolder, position: Int) {
        getItem(position).let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LicenseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLibraryBinding.inflate(inflater, parent, false)
        return LicenseViewHolder(binding)
    }

    inner class LicenseViewHolder(private val binding: ItemLibraryBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(library: Library) {
            binding.libraryAuthor.text = library.author
            binding.libraryName.text = library.libraryName
            binding.libraryVersion.text = library.libraryVersion
            binding.root.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val library = getItem(adapterPosition)
            onClick(library.repositoryLink)
        }
    }

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<Library>() {
            override fun areItemsTheSame(oldItem: Library, newItem: Library): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Library, newItem: Library): Boolean {
                return oldItem.libraryVersion == newItem.libraryVersion &&
                        oldItem.libraryName == newItem.libraryName
            }
        }
    }
}