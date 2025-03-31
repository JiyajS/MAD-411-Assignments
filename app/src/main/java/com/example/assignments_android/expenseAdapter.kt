import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignments_android.ExpenseDetailsActivity
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
//        holder.showDetail.setOnClickListener {
//            val expense1 = expenses[position]
//            val intent = Intent(holder.itemView.context, ExpenseDetailsActivity::class.java)
//            intent.putExtra("expense_name", expense1.name)
//            intent.putExtra("expense_amount", expense1.amount)
//            holder.itemView.context.startActivity(intent)
//        }
        holder.showDetail.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ExpenseDetailsActivity::class.java)
            intent.putExtra("Expense Name", expense.name)
            intent.putExtra("Expense Amount", expense.amount)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = expenses.size



    private fun DeleteExpense(position: Int) {
        expenses.removeAt(position)
        notifyItemRemoved(position)
//        notifyItemRangeChanged(position, expenses.size)
    }

    private fun showDetails(position: Int){

    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val expenseName: TextView = itemView.findViewById(R.id.expenseName)
        val amountDisplay: TextView = itemView.findViewById(R.id.amountDisplay)
        val deleteButton: Button = itemView.findViewById(R.id.delete)
        val showDetail : Button = itemView.findViewById(R.id.showDetails)
    }
}
