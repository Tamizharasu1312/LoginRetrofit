package com.quebotic.loginretrofit.helper


import android.content.Context
import kotlin.collections.HashMap


open class TKHelper {

    fun addHeader(mContext: Context): HashMap<String, String> {
        val aHeaderValues = HashMap<String, String>()
        aHeaderValues["OSType"] = "1"
        return aHeaderValues
    }

}