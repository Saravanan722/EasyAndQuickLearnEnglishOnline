package com.saravana.easyandquicklearnlanguage.chapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saravana.easyandquicklearnlanguage.databinding.ItemChapterBinding
import com.saravana.easyandquicklearnlanguage.subject.Chapter

class ChapterListAdapter(private val chapters: List<Chapter>) :
    RecyclerView.Adapter<ChapterListAdapter.ChapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ChapterViewHolder(ItemChapterBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) =
        holder.bind(chapter = chapters[position])

    override fun getItemCount() = chapters.count()

    inner class ChapterViewHolder(private val binding: ItemChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chapter: Chapter) {
            binding.chapterNumber.text = chapter.title
            binding.chapterTitle.text = chapter.descriptor
            binding.chapterCompletedPercentage.text = "${chapter.completedPercentage}%"

        }
    }
}