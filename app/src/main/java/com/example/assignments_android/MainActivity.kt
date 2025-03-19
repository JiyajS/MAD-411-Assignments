package com.example.assignments_android

import ExpenseAdapter
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignments_android.R.id

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val expenseInput = findViewById<EditText>(R.id.editText)
        val amount = findViewById<EditText>(R.id.amountInput)
        val button = findViewById<Button>(R.id.addExpense)

        val expenseList: MutableList<expenses> = ArrayList()
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ExpenseAdapter(expenseList)
        recyclerView.adapter = adapter
        button.setOnClickListener(){
            val expenseName = expenseInput.text.toString().trim()
            val expenseAmount = amount.text.toString().trim()

            if (expenseName.isNotEmpty() && expenseAmount.isNotEmpty()) {
                val newExpense = expenses(expenseName, expenseAmount)
                expenseList.add(newExpense)
                adapter.notifyItemInserted(expenseList.size -1)
                expenseInput.text.clear()
                amount.text.clear()
            }




        }


    }


    }



