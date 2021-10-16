package com.example.androidquiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    var currentPosition: Int = 1
    var presentQuestionsList: ArrayList<Question>? = null
    var presentSelectedOption: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        presentQuestionsList = Constants.getQuestions();
        assignValues()

        text_view_option_one.setOnClickListener(this)
        text_view_option_two.setOnClickListener(this)
        text_view_option_three.setOnClickListener(this)
        text_view_option_four.setOnClickListener(this)

        button_ans_submit.setOnClickListener {
           onSubmit()
        }

        Log.i("Questions Size", "${presentQuestionsList!!.size}")
    }

    private fun onSubmit(){
        if (presentSelectedOption == 0) {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
        } else {
            if (currentPosition > presentQuestionsList!!.size) {
                return;
            } else {
                currentPosition += 1
                presentSelectedOption = 0
                assignValues()
            }
        }
    }

    private fun assignValues() {
//        currentPosition = 1;
        val question: Question = presentQuestionsList!![currentPosition - 1]

        setDefaultOptions()
        progress_bar.progress = currentPosition
        progress_bar.max = presentQuestionsList!!.size
        text_view_progress.text = "$currentPosition" + "/" + progress_bar.max
        text_view_question.text = question.question
        image_view_question_image.setImageResource(question.image)
        text_view_option_one.text = question.optionOne
        text_view_option_two.text = question.optionTwo
        text_view_option_three.text = question.optionThree
        text_view_option_four.text = question.optionFour
    }


    private fun setDefaultOptions() {
        val options = ArrayList<TextView>()
        options.add(0, text_view_option_one)
        options.add(1, text_view_option_two)
        options.add(2, text_view_option_three)
        options.add(3, text_view_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("white"))
            option.typeface = Typeface.DEFAULT_BOLD
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.text_view_option_one -> setSelectedOption(text_view_option_one, 1)
            R.id.text_view_option_two -> setSelectedOption(text_view_option_two, 2)
            R.id.text_view_option_three -> setSelectedOption(text_view_option_three, 3)
            R.id.text_view_option_four -> setSelectedOption(text_view_option_four, 4)
        }
    }

    private fun setSelectedOption(tv: TextView, selectedOption: Int) {
        setDefaultOptions()
        presentSelectedOption = selectedOption
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}