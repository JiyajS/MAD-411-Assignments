package com.example.assignments_android

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ExpenseDetailsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.show_details)

        val name = intent.getStringExtra("Expense Name")
        val amount = intent.getStringExtra("Expense Amount")

        val nameView: TextView = findViewById(R.id.ShowName)
        val amountView: TextView = findViewById(R.id.showAmount)
        Log.d("ExpenseDetails", "Name: $name, Amount: $amount")

        nameView.text = "Expense Name: $name" ?: "No Name"
        amountView.text = "Amount: $amount" ?: "No amount"


    }
}