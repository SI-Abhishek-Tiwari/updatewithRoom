package com.packagename.updatewithroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.packagename.updatewithroom.databinding.AddFragmentBinding
import com.packagename.updatewithroom.room.Employee
import com.packagename.updatewithroom.room.EmployeeDatabase
import kotlinx.coroutines.launch

class AddFragment : Fragment() {

    private var _binding: AddFragmentBinding ?= null

    private val binding get() = _binding!!

    lateinit var database: EmployeeDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddFragmentBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = EmployeeDatabase.getDatabase(requireActivity())
        binding.btnSubmit.setOnClickListener {
            lifecycleScope.launch {
                database.employeeDao().insertEmployee(Employee(binding.edtAge.text.toString().toInt(),binding.edtName.text.toString(),binding.edtSalary.text.toString().toInt(),binding.edtId.text.toString().toInt(),""))

            }

            findNavController().popBackStack()

        }


    }

}