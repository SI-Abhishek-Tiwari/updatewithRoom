package com.packagename.updatewithroom.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.packagename.updatewithroom.R
import com.packagename.updatewithroom.models.Data
import com.packagename.updatewithroom.room.Employee
import java.util.zip.Inflater

class DemoAdapter(private val list : List<Employee>, private val onListClicked: (Employee) -> Unit) : RecyclerView.Adapter<DemoAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val id = itemView.findViewById<TextView>(R.id.employee_id)
        val name = itemView.findViewById<TextView>(R.id.name)
        val salary = itemView.findViewById<TextView>(R.id.salary)
        val age = itemView.findViewById<TextView>(R.id.age)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DemoAdapter.ViewHolder, position: Int) {

        val pos=holder.adapterPosition
        holder.id.text = list[pos].id.toString()
        holder.age.text = list[pos].employeeAge.toString()
        holder.salary.text = list[pos].employeeSalary.toString()
        holder.name.text = list[pos].employeeName
        holder.itemView.rootView.setOnClickListener {
            onListClicked(list[pos])
        }


    }

//    class Diffutil : DiffUtil.ItemCallback<Data>() {
//        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
//            return oldItem == newItem
//        }
//    }


}