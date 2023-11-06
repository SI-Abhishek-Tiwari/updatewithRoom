package com.packagename.updatewithroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.packagename.updatewithroom.Adapter.DemoAdapter
import com.packagename.updatewithroom.models.EmployeeResponse
import com.packagename.updatewithroom.room.Employee
import com.packagename.updatewithroom.room.EmployeeDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DemoAdapter
    lateinit var database: EmployeeDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*

        val recyclerview = findViewById<RecyclerView>(R.id.rl)

        database = EmployeeDatabase.getDatabase(this)



        lifecycleScope.launch{
            try{
                val response = RetrofitInstance.api.getEmployee()
                Log.d("response", response.toString())

        //        database.employeeDao().updateEmployee(Employee(23,"Abhi",50000000,1,""))
         //       database.employeeDao().insertEmployee(Employee(22,"Ravi",5000000,25,""))
                database.employeeDao().deleteEmployee(Employee(22,"Ravi",5000000,25,""))

                withContext(Dispatchers.Main){
                    if (response.isSuccessful && response != null){
                       val list = response.body()?.data ?: listOf()
                        for (items in list){
                            val employee = Employee(items.employeeAge,items.employeeName,items.employeeSalary,items.id,items.profileImage)
                            database.employeeDao().insertEmployee(employee)
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
            catch (e:Exception){

            }

        }

        database.employeeDao().getEmployee().observe(this, Observer {
            if (it != null){

                recyclerview.adapter = DemoAdapter(it)

            }
        })

         */




    }
}