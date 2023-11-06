package com.packagename.updatewithroom.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Employee")
data class Employee(

    val employeeAge: Int,
    val employeeName: String,
    val employeeSalary: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val profileImage: String
)
