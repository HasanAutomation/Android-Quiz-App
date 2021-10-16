package com.example.androidquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Hide status bar
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        button_submit.setOnClickListener {
            handleSubmit()
        }


    }
    private fun handleSubmit(){
        if(isEmpty(edit_text_name.text.toString())){
            Toast.makeText(this,"Please enter a name ${edit_text_name.text.toString()}",Toast.LENGTH_SHORT).show();
            return
        }
        val quizIntent = Intent(this,QuizQuestionsActivity::class.java);
        quizIntent.putExtra("name",edit_text_name.text.toString())
        startActivity(quizIntent)
        finish()
    }

}