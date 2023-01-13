package com.saravana.easyandquicklearnlanguage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saravana.easyandquicklearnlanguage.databinding.ActivityMainBinding
import com.saravana.easyandquicklearnlanguage.subject.SubjectListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialSetup()
    }

    private fun initialSetup() {
        binding.nextButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SubjectListActivity::class.java)
            startActivity(intent)
        }
    }
}