package com.example.assignments_android

import ExpenseAdapter
import android.annotation.SuppressLint
import android.content.Context
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
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignments_android.R.id
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
private val expenseList = mutableListOf<expenses>()

class MainActivity : AppCompatActivity() {
    //    private val fileName = "expenses.json"
//
//    private val expenseList = mutableListOf<expenses>()
//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d("ActivityLifecycle", "onCreate called")

        val headerFragment = HeaderFragment()
        val footerFragment = FooterFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.header_fragment, headerFragment)
            .replace(R.id.footerFragment, footerFragment)
            .commit()

        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.na)


//        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        val expenseInput = findViewById<EditText>(R.id.editText)
//        val amount = findViewById<EditText>(R.id.amountInput)
//        val button = findViewById<Button>(R.id.addExpense)
//        val tipsButton = findViewById<Button>(R.id.tipsButton)
//
//        val expenseList: MutableList<expenses> = ArrayList()
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        val adapter = ExpenseAdapter(expenseList)
//        recyclerView.adapter = adapter
//        expenseList.addAll(loadExpense(this))
//        adapter.notifyDataSetChanged()
//        saveEntryToFile(this, expenseList)
//        loadExpense(this)
//
//        tipsButton.setOnClickListener(){
//            val url = "https://www.bp.com/en/global/corporate/news-and-insights/press-releases/growing-shareholder-value-a-reset-bp.html#14"
//            val intent1 = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//            startActivity(intent1)
//        }
//        button.setOnClickListener() {
//            val expenseName = expenseInput.text.toString().trim()
//            val expenseAmount = amount.text.toString().trim()
//            val newExpense = expenses(expenseName, expenseAmount)
//
//            if (expenseName.isNotEmpty() && expenseAmount.isNotEmpty()) {
//                expenseList.add(newExpense)
//                adapter.notifyItemInserted(expenseList.size - 1)
//                expenseInput.text.clear()
//                amount.text.clear()
//            }
////            totalExp66ense(footerFragment, expenseList)
//
//        }
//
//
//
//    }
////    private fun totalExpense(footerFragment: FooterFragment, expenseList: List<expenses>) {
////        val total = expenseList.sumOf {
////            // Convert each amount to Double safely, treating invalid ones as 0.0
////            it.amount?.toDoubleOrNull() ?: 0.0
////        }
////        footerFragment.totalExpense(total)
//
////    }
//    private fun saveEntryToFile(context: Context, expenses: List<expenses>) {
//        try {
//            val json = Gson().toJson(expenses)
//            context.openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
//                output.write(json.toByteArray())
//            }
//            Log.d("FileStorage", "Expenses saved successfully")
//        } catch (e: IOException) {
//            Log.e("FileStorage", "Error saving expenses: ${e.message}")
//        }
//
//
//    }
//    private fun loadExpense(context: Context): MutableList<expenses>{
//
//        val expenseList: MutableList<expenses> = mutableListOf()
//        try {
//            val file = File(context.filesDir, fileName)
//            if (!file.exists()) return expenseList
//
//            val json = file.readText()
//            val type = object : TypeToken<List<expenses>>() {}.type
//            val loadExpenses : List<expenses> = Gson().fromJson(json, type)
//            expenseList.addAll(loadExpenses)
//            Log.d("FileStorage", "Expenses loaded successfully")
//        }catch (e : FileNotFoundException){
//            Log.e("FileStorage", "File not Found: ${e.message}")
//        }catch (e : IOException){
//            Log.e("FileStorage", "Error reading file: ${e.message}")
//        }
//        return expenseList
//    }
//        override fun onStart() {
//            super.onStart()
//            Log.d("ActivityLifecycle", "onStart called")
//        }
//
//        override fun onResume() {
//            super.onResume()
//            Log.d("ActivityLifecycle", "onResume called")
//        }
//
//        override fun onPause() {
//            super.onPause()
//            Log.d("ActivityLifecycle", "onPause called")
//        }
//
//        override fun onStop() {
//            super.onStop()
//            Log.d("ActivityLifecycle", "onStop called")
//        }
//
//        override fun onDestroy() {
//            super.onDestroy()
//            Log.d("ActivityLifecycle", "onDestroy called")
//        }
//    }
    }
}



