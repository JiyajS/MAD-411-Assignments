package com.example.assignments_android

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignments_android.R.id

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val expenseInput = findViewById<EditText>(R.id.editText)
        val amount = findViewById<EditText>(R.id.amountInput)
        val button = findViewById<Button>(R.id.addExpense)

        button.setOnClickListener(){
            setContentView(R.layout.expense)
            val expenseName = expenseInput.text.toString().trim()
            val amountInserted = amount.text.toString().trim()
            expenseInput.setText(expenseName)



        }
    }


}
