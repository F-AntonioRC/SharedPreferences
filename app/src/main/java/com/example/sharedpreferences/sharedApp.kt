package com.example.sharedpreferences

import android.app.Application
//CLASE QUE SE INICIA INMEDIATAMENTE
class sharedApp : Application() {
    companion object {
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}