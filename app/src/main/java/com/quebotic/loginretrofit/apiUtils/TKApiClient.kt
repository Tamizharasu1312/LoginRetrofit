package com.ers.tkenterprise.apiUtils


import com.quebotic.loginretrofit.preference.TKPrefs
import com.quebotic.loginretrofit.webservice.CommonValues.SITE_URL
import com.quebotic.loginretrofit.webservice.TKWebserviceInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object TKApiClient {

    private var retrofit: Retrofit? = null

    val interceptor = HttpLoggingInterceptor()

    val okHttpClient = OkHttpClient().newBuilder().connectTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES).addInterceptor(interceptor).build()

    //Call Webservice - LIVE / LOCAL
    fun getService(): TKWebserviceInterface {
        return client.create(TKWebserviceInterface::class.java)
    }

    val client: Retrofit
        get() {
            if (retrofit == null) {

                retrofit = Retrofit.Builder().baseUrl(TKPrefs.getString(SITE_URL, "")!!).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return this.retrofit!!
        }

    //Get Base URL from Login Screen
    fun changeApiBaseUrl(newApiBaseUrl: String) {

        retrofit = Retrofit.Builder().baseUrl(newApiBaseUrl).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
    }
}