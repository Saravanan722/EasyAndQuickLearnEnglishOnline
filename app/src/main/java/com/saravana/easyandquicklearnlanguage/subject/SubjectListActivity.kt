package com.saravana.easyandquicklearnlanguage.subject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.saravana.easyandquicklearnlanguage.MainActivity
import com.saravana.easyandquicklearnlanguage.R
import com.saravana.easyandquicklearnlanguage.chapter.ChapterListActivity
import com.saravana.easyandquicklearnlanguage.databinding.ActivitySubjectListBinding

class SubjectListActivity : AppCompatActivity(), SubjectItemClickListener {

    private lateinit var binding: ActivitySubjectListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialSetup()
    }

    private fun initialSetup() {
        binding.backButton.setOnClickListener {
            val intent = Intent(this@SubjectListActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = SubjectListAdapter(getChapters(), this)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        itemDecoration.setDrawable(AppCompatResources.getDrawable(this, R.drawable.divider)!!)
        binding.recyclerView.addItemDecoration(itemDecoration)
    }

    override fun onClick(subject: Subject) {
        Toast.makeText(this, subject.title, Toast.LENGTH_SHORT).show()
        val intent = Intent(this@SubjectListActivity, ChapterListActivity::class.java)
        startActivity(intent)
    }

    /**
     * This function provide dummy data for testing purpose only it will replace once REST API integrated
     */
    private fun getChapters(): List<Subject> {
        return listOf(
            Subject("Unit 1", "Sample Description"),
            Subject("Unit 2", "Sample Description"),
            Subject("Unit 3", "Sample Description"),
            Subject("Unit 4", "Sample Description"),
            Subject("Unit 5", "Sample Description"),
            Subject("Unit 6", "Sample Description"),
            Subject("Unit 7", "Sample Description"),
            Subject("Unit 8", "Sample Description"),
            Subject("Unit 9", "Sample Description"),
            Subject("Unit 10", "Sample Description")
        )
    }
}