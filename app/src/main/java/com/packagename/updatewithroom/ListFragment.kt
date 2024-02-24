package com.packagename.updatewithroom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.packagename.updatewithroom.Adapter.DemoAdapter
import com.packagename.updatewithroom.databinding.ListFragmentBinding
import com.packagename.updatewithroom.room.Employee
import com.packagename.updatewithroom.room.EmployeeDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ListFragment: Fragment() {

    private var _binding : ListFragmentBinding ?= null

    private val binding get() = _binding!!

    private lateinit var adapter : DemoAdapter

    lateinit var database: EmployeeDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListFragmentBinding.inflate(inflater,container,false)


        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = binding.rl

        database = EmployeeDatabase.getDatabase(requireActivity())

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }





        lifecycleScope.launch{
            try{
                val response = RetrofitInstance.api.getEmployee()
                Log.d("response", response.toString())

//                        database.employeeDao().updateEmployee(Employee(23,"Abhi",50000000,1,""))
                      database.employeeDao().insertEmployee(Employee(24,"Ravi",5000000,20,""))
              //  database.employeeDao().deleteEmployee(Employee(22,"Ravi",5000000,25,""))


                withContext(Dispatchers.Main){
                    if (response.isSuccessful && response != null){
                        val list = response.body()?.data ?: listOf()
                        for (items in list){
                            val employee = Employee(items.employeeAge,items.employeeName,items.employeeSalary,items.id,items.profileImage)
                          database.employeeDao().insertEmployee(employee)
                    //        database.employeeDao().updateEmployee(employee)
                        }



                        Log.d("response list", list.toString())
//                        adapter = DemoAdapter(database.employeeDao().getEmployee())

//                        recyclerview.adapter = adapter


                    }
                    else{
                        Log.e("API Request Error", "API request failed")
                    }
                }
            }
            catch (e: Exception){

            }

        }

        database.employeeDao().getEmployee().observe(requireActivity(), Observer {
            if (it != null){

                recyclerview.adapter = DemoAdapter(requireActivity(),it,::onListClicked,::onItemClicked)

            }
        })

    }

    private fun onListClicked(employee: Employee){
        val bundle = Bundle()
        bundle.putString("EmployeeList",Gson().toJson(employee))
        findNavController().navigate(R.id.action_listFragment_to_editFragment,bundle)
    }

    private fun onItemClicked(employee: Employee){
        lifecycleScope.launch {
            database.employeeDao().deleteEmployee(employee)
        }
    }



}