import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignments_android.R
import com.example.assignments_android.expenses

class ExpenseAdapter(private val expenses: MutableList<expenses>) :
    RecyclerView.Adapter<ExpenseAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.expense, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val expense = expenses[position]
        holder.expenseName.text = expense.name
        holder.amountDisplay.text = expense.amount

        holder.deleteButton.setOnClickListener {
            DeleteExpense(position)
        }
    }

    override fun getItemCount() = expenses.size



    private fun DeleteExpense(position: Int) {
        expenses.removeAt(position)
        notifyItemRemoved(position)
//        notifyItemRangeChanged(position, expenses.size)
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val expenseName: TextView = itemView.findViewById(R.id.expenseName)
        val amountDisplay: TextView = itemView.findViewById(R.id.amountDisplay)
        val deleteButton: Button = itemView.findViewById(R.id.delete)
    }
}
