package com.example.androidquiz

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questions = ArrayList<Question>();
        val quest1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "India",
            "Brazil",
            "Denmark",
            "USA",
            2
        )
        val quest2 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India",
            "Brazil",
            "Denmark",
            "USA",
            1
        )
        val quest3 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "India",
            "Brazil",
            "Argentina",
            "USA",
            3
        )

        questions.add(quest1)
        questions.add(quest2)
        questions.add(quest3)

        return questions
    }
}