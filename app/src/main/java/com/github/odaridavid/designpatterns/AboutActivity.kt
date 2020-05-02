package com.github.odaridavid.designpatterns

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.odaridavid.designpatterns.databinding.ActivityAboutBinding
import com.github.odaridavid.designpatterns.databinding.ItemLibraryBinding
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.entity.Library
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val libs = Libs(this).libraries

        binding.appVersionTextView.text =
            getString(R.string.template_app_version, BuildConfig.VERSION_NAME)

        val librariesAdapter = LibrariesAdapter { url ->
            val repoUrl = checkUrlScheme(url)
            val browserIntent = Intent(Intent.ACTION_VIEW, repoUrl.toUri())
            startActivity(browserIntent)
        }

        binding.licensesRecyclerView.adapter = ScaleInAnimationAdapter(librariesAdapter.apply {
            submitList(libs)
        })
    }

}

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