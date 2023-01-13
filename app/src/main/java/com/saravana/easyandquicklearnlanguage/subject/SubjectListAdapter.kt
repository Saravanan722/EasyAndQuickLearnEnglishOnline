package com.saravana.easyandquicklearnlanguage.subject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saravana.easyandquicklearnlanguage.databinding.ItemSubjectBinding

data class Subject(
    val title: String,
    val descriptor: String,
    val chapter: List<Chapter> = listOf()
) {
    val completedPercentage: Double
        get() {
            return 0.0
        }
}

data class Chapter(
    val title: String,
    val descriptor: String,
    val completedPercentage: Double
)

interface SubjectItemClickListener {
    fun onClick(subject: Subject)
}

class SubjectListAdapter(
    private val subjects: List<Subject>,
    val listener: SubjectItemClickListener
) : RecyclerView.Adapter<SubjectListAdapter.SubjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SubjectViewHolder(ItemSubjectBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount() = subjects.count()

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) =
        holder.bind(subjects[position])

    inner class SubjectViewHolder(private val binding: ItemSubjectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var subject: Subject

        init {
            binding.root.setOnClickListener {
                listener.onClick(subject)
            }
        }

        fun bind(subject: Subject) {
            this.subject = subject
            binding.subjectTotalPercentage.text = "${subject.completedPercentage}%"
            binding.subjectTitle.text = subject.title
            binding.subjectDescription.text = subject.descriptor
        }
    }
}