package com.packagename.updatewithroom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.packagename.updatewithroom.databinding.EditFragmentBinding
import com.packagename.updatewithroom.room.Employee
import com.packagename.updatewithroom.room.EmployeeDatabase
import kotlinx.coroutines.launch

class EditFragment: Fragment() {

    private var _binding: EditFragmentBinding ?= null

    private val binding get() = _binding!!

    lateinit var database: EmployeeDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EditFragmentBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = EmployeeDatabase.getDatabase(requireActivity())

        val jsonEmployee = arguments?.getString("EmployeeList")
        if (jsonEmployee != null){
            val employeeList = Gson().fromJson(jsonEmployee,Employee::class.java)
            binding.edtId.setText(employeeList.id.toString())
            binding.edtName.setText(employeeList.employeeName)
            binding.edtSalary.setText(employeeList.employeeSalary.toString())
            binding.edtAge.setText(employeeList.employeeAge.toString())
        }

        userInput()
    }

    private fun userInput(){
        binding.btnSubmit.setOnClickListener {
            lifecycleScope.launch {
              //  database.employeeDao().insertEmployee(Employee(binding.edtId.text.toString().toInt(),binding.edtName.text.toString(),binding.edtSalary.text.toString().toInt(),binding.edtAge.text.toString().toInt(),""))
              //  database.employeeDao().updateEmployee(Employee(binding.edtId.text.toString().toInt(),binding.edtName.text.toString(),binding.edtSalary.text.toString().toInt(),binding.edtAge.text.toString().toInt(),""))
                database.employeeDao().updateEmployee(Employee(binding.edtAge.text.toString().toInt(),binding.edtName.text.toString(),binding.edtSalary.text.toString().toInt(),binding.edtId.text.toString().toInt(),""))
            //    Log.d("age",binding.edtAge.text.toString().toInt().toString() )

            }

            findNavController().popBackStack()

        }
    }
}