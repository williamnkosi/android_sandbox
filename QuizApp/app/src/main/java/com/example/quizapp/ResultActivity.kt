package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        tv_user_name.text = userName
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        tv_score.text = "Your Score is $correctAnswers out of $totalQuestions"

        result_button.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}