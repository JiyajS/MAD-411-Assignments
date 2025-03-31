package com.example.assignments_android

import ExpenseAdapter
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException


class   ExpenseListFragment : Fragment() {
    private val fileName = "expenses.json"
    private val expenseList = mutableListOf<expenses>()
    private lateinit var adapter: ExpenseAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var expenseInput: EditText
    private lateinit var amount: EditText
    private lateinit var button: Button
    private lateinit var tipsButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_expense_list, container, false)

//        recyclerView = view.findViewById(R.id.recyclerView)

//        val amount = view.findViewById<EditText>(R.id.amountInput)
//        val button = view.findViewById<Button>(R.id.addExpense)
//        val tipsButton = view.findViewById<Button>(R.id.tipsButton)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ExpenseAdapter(expenseList)
        recyclerView.adapter = adapter

        expenseList.addAll(loadExpense(requireContext()))
        adapter.notifyDataSetChanged()

        tipsButton.setOnClickListener {
            val url = "https://www.bp.com/en/global/corporate/news-and-insights/press-releases/growing-shareholder-value-a-reset-bp.html#14"
            val intent1 = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent1)
        }


        button.setOnClickListener {
            val expenseName = expenseInput.text.toString().trim()
            val expenseAmount = amount.text.toString().trim()

            if (expenseName.isNotEmpty() && expenseAmount.isNotEmpty()) {
                val newExpense = expenses(expenseName, expenseAmount)
                expenseList.add(newExpense)
                adapter.notifyItemInserted(expenseList.size - 1)
                expenseInput.text.clear()
                amount.text.clear()

                saveEntryToFile(requireContext(), expenseList)
            }
        }

        return view
    }

    private fun saveEntryToFile(context: Context, expenses: List<expenses>) {
        try {
            val json = Gson().toJson(expenses)
            context.openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
                output.write(json.toByteArray())
            }
            Log.d("FileStorage", "Expenses saved successfully")
        } catch (e: IOException) {
            Log.e("FileStorage", "Error saving expenses: ${e.message}")
        }
    }

    private fun loadExpense(context: Context): MutableList<expenses> {
        val expenseList: MutableList<expenses> = mutableListOf()
        try {
            val file = File(context.filesDir, fileName)
            if (!file.exists()) return expenseList

            val json = file.readText()
            val type = object : TypeToken<List<expenses>>() {}.type
            val loadExpenses: List<expenses> = Gson().fromJson(json, type)
            expenseList.addAll(loadExpenses)
            Log.d("FileStorage", "Expenses loaded successfully")
        } catch (e: FileNotFoundException) {
            Log.e("FileStorage", "File not found: ${e.message}")
        } catch (e: IOException) {
            Log.e("FileStorage", "Error reading file: ${e.message}")
        }
        return expenseList
    }
}