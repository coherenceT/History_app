package com.example.historyapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private val historicalFigures = mapOf(
        95 to "Nelson Mandela",
        25 to "to silo",
        32 to "Alexander the Great",
        19 to "Joan of Arc",
        39 to "Cleopatra",
        67 to "Leonardo Da Vinci",
        15 to "Anne Frank",
        18 to "Tutankhamun",
        78 to "Mhat"


        )

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val clearButton = findViewById<Button>(R.id.clearButton)

        clearButton.setOnClickListener {
            ageEditText.text.clear()


            generateButton.setOnClickListener {
                val age = ageEditText.text.toString().toIntOrNull()
                age?.let {
                    val figure = historicalFigures[age]
                    if (figure != null) {
                        resultTextView.text = "You are $age years old, which is the same age as $figure."
                    } else {
                        resultTextView.text =
                            "There is no historical figure in our records who was $age years old."

                    }
                } ?: run {
                    resultTextView.text = "Please enter a valid age."
                }
            }
        }
    }
}