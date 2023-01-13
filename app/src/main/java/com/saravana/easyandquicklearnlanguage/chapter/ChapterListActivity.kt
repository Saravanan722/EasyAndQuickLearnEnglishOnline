package com.saravana.easyandquicklearnlanguage.chapter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.saravana.easyandquicklearnlanguage.databinding.ActivityChapterListBinding
import com.saravana.easyandquicklearnlanguage.subject.Chapter
import com.saravana.easyandquicklearnlanguage.subject.SubjectListActivity

class ChapterListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChapterListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialSetup()
    }

    private fun initialSetup() {
        binding.backButton1.setOnClickListener {
            val intent = Intent(this@ChapterListActivity, SubjectListActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerView.adapter = ChapterListAdapter(
            listOf(
                Chapter("Chapter 1", "  Introduction", 0.0),
                Chapter("Chapter 2", "  School", 0.0),
                Chapter("Chapter 3", "  Jobs", 0.0),
                Chapter("Chapter 4", "  Jobs Interview", 0.0),
                Chapter("Chapter 5", "  University", 0.0),
            )
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}