package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionList = Constants.getQuestions()

        Log.i("Questions Size", "${questionList.size}")
        val currentQuestion =  1
        val question: Question? = questionList[currentQuestion -1]
        progressBar.progress = currentQuestion
        tv_progress.text = "$currentQuestion/${progressBar.max}"
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question!!.optionOne
        tv_option_two.text = question!!.optionTwo
        tv_option_three.text = question!!.optionThree
        tv_option_four.text = question!!.optionFour
        val correctAnswer = questionList[0].correctAnswer
    }
}