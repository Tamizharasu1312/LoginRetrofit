package com.quebotic.loginretrofit.activity

import android.content.Context
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

class MainActivity : AppCompatActivity() {

    var mSiteURLEDT = "https://jayanathanchits.in/"

    private var mContext: Context? = null


    //Layout Control
    private var mbtLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            mContext = this@MainActivity
            TKPrefs.putString(SITE_URL, mSiteURLEDT)

            initViews()

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
                TKApiClient.changeApiBaseUrl(TKPrefs.getString(SITE_URL, "")!!)
                callLogin()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun callLogin() {

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
                    if(response.isSuccessful){
                        //Log.d("LoginResponse", response.body()?.Data().toString())

                        //Log.e("Error", response.errorBody().toString())

                        /*if (response.body()?.statusCode == 200) {

                            TKPrefs.putObject(LOGIN_OBJECT, response.body()?.data!!.logins)
                            TKPrefs.putObject(USER_OBJECT, response.body()?.data!!.userInfo)
                            //mDBHelper?.storeLoginInfo(response.body()?.data!!.logins)

                            TKPrefs.putString(TOKEN, response.body()?.accessToken.toString())


                        }*/
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
