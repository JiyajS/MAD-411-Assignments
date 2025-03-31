package com.example.assignments_android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ExpenseDetailsFragment : Fragment() {
    private lateinit var nameView: TextView
    private lateinit var amountView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expense_details, container, false)
//        val view = inflater.inflate(R.layout.fragment_expense_details, container, false)

//        val name = intent.getStringExtra("Expense Name")
//        val amount = intent.getStringExtra("Expense Amount")
//
        val nameView: TextView = findViewById(R.id.ShowName)
        val amountView: TextView = findViewById(R.id.showAmount)
        Log.d("ExpenseDetails", "Name: $name, Amount: $amount")

        nameView.text = "Expense Name: $name" ?: "No Name"
        amountView.text = "Amount: $amount" ?: "No amount"

        val name

    }
    
}