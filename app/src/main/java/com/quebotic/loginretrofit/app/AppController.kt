package com.quebotic.loginretrofit.app

import android.app.Application
import android.content.ContextWrapper
import com.quebotic.loginretrofit.preference.TKPrefs

class AppController : Application() {

    private var activityVisible: Boolean = false

    fun isActivityVisible(): Boolean {
        return activityVisible
    }

    fun activityResumed() {
        activityVisible = true
    }

    fun activityPaused() {
        activityVisible = false
    }


    companion object {
        private var appInstant: AppController? = null
        fun getInstance(): AppController {
            if (appInstant == null) {
                appInstant = AppController()
            }
            return appInstant!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        appInstant = this

        TKPrefs.Builder().setContext(this).setMode(ContextWrapper.MODE_PRIVATE).setPrefsName(packageName).setUseDefaultSharedPreference(true).build()



    }
}