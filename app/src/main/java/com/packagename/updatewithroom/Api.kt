package com.packagename.updatewithroom

import com.packagename.updatewithroom.models.EmployeeResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/api/v1/employees")
    suspend fun getEmployee() : Response<EmployeeResponse>

}