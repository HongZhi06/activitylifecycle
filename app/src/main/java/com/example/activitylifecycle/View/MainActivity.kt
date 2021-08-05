package com.example.activitylifecycle.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.activitylifecycle.R
import com.example.activitylifecycle.models.QuestionModel

class MainActivity : AppCompatActivity() {

    private lateinit var myModel: QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myModel = QuestionModel.getInstance()

        val btn : Button = findViewById(R.id.btnNext)

        btn.setOnClickListener(){
            var intent : Intent = Intent(this, SecondActivity::class.java )

            myModel.name = findViewById<EditText>(R.id.tfName).text.toString()
            startActivity(intent)
        }

    }
}