package com.example.activitylifecycle.models

import androidx.lifecycle.ViewModel

class QuestionModel : ViewModel() {
    var name : String = ""
    var no1 : Int = 0
    var no2 : Int = 0


    init{
        generateQuestion()
    }

    fun generateQuestion(): String{
        no1 = (Math.random()*100).toInt()
        no2 = (Math.random()*100).toInt()

        return "${no1} + ${no2} = ?"
    }

    fun getQuestion(): String{
        return "${no1} + ${no2} = ?"
    }

    companion object{
        private var instance : QuestionModel? = null

        // synchronized will sync all instances
        fun getInstance() = instance?: synchronized(QuestionModel::class.java){
            instance ?: QuestionModel().also{ instance = it}
        }

    }
}