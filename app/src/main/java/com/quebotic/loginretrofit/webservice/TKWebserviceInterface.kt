package com.quebotic.loginretrofit.webservice



import com.google.gson.JsonObject
import com.quebotic.loginretrofit.pojo.LoginResponse
import retrofit2.Call
import retrofit2.http.*


interface TKWebserviceInterface {

    @Headers("Content-Type: application/json")
    @POST("/paycollect/v1/api/adminlogin")
    //fun getLogin(@Body aJson: JsonObject): Call<LoginResponse>
   fun getLogin(@HeaderMap aMap: HashMap<String, String>): Call<LoginResponse>




}