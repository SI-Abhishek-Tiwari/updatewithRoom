package com.packagename.updatewithroom.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase(){

    abstract fun employeeDao() : EmployeDao

    companion object{
        private var instance: EmployeeDatabase ?= null

        fun getDatabase(context: Context) : EmployeeDatabase{
            synchronized(this){
                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        EmployeeDatabase::class.java,"EmployeeDB")
                        .build()

                }
                return instance!!
            }

        }
    }


}