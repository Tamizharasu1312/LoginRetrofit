package com.quebotic.loginretrofit.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.ers.tkenterprise.apiUtils.TKApiClient
import com.google.gson.JsonObject
import com.quebotic.loginretrofit.R
import com.quebotic.loginretrofit.helper.TKHelper
import com.quebotic.loginretrofit.pojo.LoginResponse
import com.quebotic.loginretrofit.preference.TKPrefs
import com.quebotic.loginretrofit.webservice.CommonValues.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllListActivity : AppCompatActivity() {

    private var mContext: Context? = null


    //Layout Control
    private var mbtLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alllist_layout)

        try {
            mContext = this@AllListActivity
            initViews()

            getAllList()

            clickListener()
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    private fun initViews() {
        mbtLogin = findViewById(R.id.login_button)
    }

    private fun clickListener() {

        try {
            mbtLogin!!.setOnClickListener {
                getAllList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getAllList() {

        val aJsonObj = JsonObject()
        aJsonObj.addProperty("code", "e1206")
        aJsonObj.addProperty("password", "123")


        //TKApiClient.getService().getLogin(addHeader())
        TKApiClient.getService().getLogin(aJsonObj)
            .enqueue(object :
                Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {

                    if(response.code()==200){
                        if(response.body()?.message.isNullOrEmpty()){
                            Log.d("code", response.body()?.code!!)
                            val intent = Intent(this@AllListActivity, AllListActivity::class.java)
                            // start your next activity
                            startActivity(intent)
                        }
                    }
                    }



                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("Error", t.toString())


                }
            })
    }
    fun addHeader(): HashMap<String, String> {
        val aHeaderValues = HashMap<String, String>()
        aHeaderValues.put("code","e1206")
        aHeaderValues.put("password","123")
        return aHeaderValues
    }
}
