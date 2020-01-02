package com.quebotic.loginretrofit.helper


import kotlin.collections.HashMap


open class TKHelper {

    fun addHeader(): HashMap<String, String> {
        val aHeaderValues = HashMap<String, String>()
        aHeaderValues["Content-Type"] = "application/json"
        return aHeaderValues
    }

}