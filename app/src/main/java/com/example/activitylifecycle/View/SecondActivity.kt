package com.example.activitylifecycle.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.activitylifecycle.R
import com.example.activitylifecycle.models.QuestionModel

class SecondActivity : AppCompatActivity() {

    private lateinit var myModel: QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.w("LifeCycle", "OnCreate")

        val btn: Button = findViewById(R.id.btnAdd)
        val tvQuestion: TextView = findViewById(R.id.tvQuestion)
        val tvName: TextView = findViewById(R.id.tvName)

        if (savedInstanceState != null)
        tvQuestion.text = savedInstanceState.getString("question")

        //myModel = QuestionModel()

        //myModel = ViewModelProvider(this).get(QuestionModel::class.java)
        myModel = QuestionModel.getInstance()

        tvQuestion.text = myModel.getQuestion()
        tvName.text = myModel.name
        btn.setOnClickListener() {
            tvQuestion.text = myModel.generateQuestion()
        }
    }

    override fun onStart(){
        super.onStart()
        Log.i("Lifecycle", "onStart")
    }

    override fun onRestart(){
        super.onRestart()
        Log.i("Lifecycle", "onRestart")
    }

    override fun onResume(){
        super.onResume()
        Log.i("Lifecycle", "onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.i("Lifecycle", "onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.i("Lifecycle", "onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        var question = findViewById<TextView>(R.id.tvQuestion).text.toString()

        outState.putString("question",question)

    }



        fun generateQuestion() : String{
            var no1 = (Math.random()*100).toInt()
            var no2 = (Math.random()*100).toInt()

            return "${no1} + ${no2} = ?"
        }
    }
