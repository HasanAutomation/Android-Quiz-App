package com.example.androidquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {
    var currentPosition: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        val questionsList = Constants.getQuestions();
        assignValues(questionsList)
        button_ans_submit.setOnClickListener {
            currentPosition += 1
            onSubmit(questionsList)
        }

        Log.i("Questions Size", "${questionsList.size}")
    }

    private fun assignValues(questions: ArrayList<Question>) {
//        currentPosition = 1;
        val question: Question = questions[currentPosition - 1]
        progress_bar.progress = currentPosition
        progress_bar.max = questions.size
        text_view_progress.text = "$currentPosition" + "/" + progress_bar.max
        text_view_question.text = question.question
        image_view_question_image.setImageResource(question.image)
        text_view_option_one.text = question.optionOne
        text_view_option_two.text = question.optionTwo
        text_view_option_three.text = question.optionThree
        text_view_option_four.text = question.optionFour
    }

    private fun onSubmit(questions: ArrayList<Question>) {
        if (currentPosition > questions.size) return
        assignValues(questions)
    }
}