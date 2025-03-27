package com.example.assignments_android

import ExpenseAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignments_android.R.id




class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d("ActivityLifecycle", "onCreate called")

        val headerFragment = HeaderFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.header_fragment,headerFragment)
            .commit()

        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val expenseInput = findViewById<EditText>(R.id.editText)
        val amount = findViewById<EditText>(R.id.amountInput)
        val button = findViewById<Button>(R.id.addExpense)
        val tipsButton = findViewById<Button>(R.id.tipsButton)

        val expenseList: MutableList<expenses> = ArrayList()
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ExpenseAdapter(expenseList)
        recyclerView.adapter = adapter

        tipsButton.setOnClickListener(){
            val url = "https://www.bp.com/en/global/corporate/news-and-insights/press-releases/growing-shareholder-value-a-reset-bp.html#14"
            val intent1 = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent1)
        }
        button.setOnClickListener() {
            val expenseName = expenseInput.text.toString().trim()
            val expenseAmount = amount.text.toString().trim()
            val newExpense = expenses(expenseName, expenseAmount)

            if (expenseName.isNotEmpty() && expenseAmount.isNotEmpty()) {
                expenseList.add(newExpense)
                adapter.notifyItemInserted(expenseList.size - 1)
                expenseInput.text.clear()
                amount.text.clear()
            }
        }

    }
        override fun onStart() {
            super.onStart()
            Log.d("ActivityLifecycle", "onStart called")
        }

        override fun onResume() {
            super.onResume()
            Log.d("ActivityLifecycle", "onResume called")
        }

        override fun onPause() {
            super.onPause()
            Log.d("ActivityLifecycle", "onPause called")
        }

        override fun onStop() {
            super.onStop()
            Log.d("ActivityLifecycle", "onStop called")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d("ActivityLifecycle", "onDestroy called")
        }
    }



