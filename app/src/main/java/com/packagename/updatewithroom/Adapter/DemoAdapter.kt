package com.packagename.updatewithroom.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.packagename.updatewithroom.R
import com.packagename.updatewithroom.models.Data
import com.packagename.updatewithroom.room.Employee
import com.packagename.updatewithroom.room.EmployeeDatabase
import java.util.zip.Inflater

class DemoAdapter(private val context: Context ,private val list : List<Employee>, private val onListClicked: (Employee) -> Unit,private val onItemClicked: (Employee) -> Unit) : RecyclerView.Adapter<DemoAdapter.ViewHolder>() {

        private var listData: MutableList<Employee> = list as MutableList<Employee>
        lateinit var database: EmployeeDatabase

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val id = itemView.findViewById<TextView>(R.id.employee_id)
        val name = itemView.findViewById<TextView>(R.id.name)
        val salary = itemView.findViewById<TextView>(R.id.salary)
        val age = itemView.findViewById<TextView>(R.id.age)
        val delete = itemView.findViewById<ImageButton>(R.id.delete_btn)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DemoAdapter.ViewHolder, position: Int) {

        database = EmployeeDatabase.getDatabase(context)

        val pos=holder.adapterPosition
        holder.id.text = list[pos].id.toString()
        holder.age.text = list[pos].employeeAge.toString()
        holder.salary.text = list[pos].employeeSalary.toString()
        holder.name.text = list[pos].employeeName
        holder.itemView.rootView.setOnClickListener {
            onListClicked(list[pos])
        }

        holder.delete.setOnClickListener {
            onItemClicked(Employee(list[pos].employeeAge.toString().toInt(),list[pos].employeeName.toString(),list[pos].employeeSalary.toString().toInt(),list[pos].id.toString().toInt(),""))
            deleteItem(pos)
            //  database.employeeDao().deleteEmployee(Employee(list[pos].employeeAge.toString().toInt(),list[pos].employeeName.toString(),list[pos].employeeSalary.toString().toInt(),list[pos].id.toString().toInt(),""))
        }


    }

    fun deleteItem(position : Int){
        listData.removeAt(position)
        notifyDataSetChanged()
    }




}