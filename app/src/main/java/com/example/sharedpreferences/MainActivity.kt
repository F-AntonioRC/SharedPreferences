package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var btnSaveValue : Button
    lateinit var btnDeleteValue : Button
    lateinit var etName : EditText
    lateinit var tvName : TextView

    val EMPTY_VALUE = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSaveValue = findViewById(R.id.btnSaveValue)
        btnDeleteValue = findViewById(R.id.btnDeleteValue)
        etName = findViewById(R.id.etName)
        tvName = findViewById(R.id.tvName)
        configView()

        btnSaveValue.setOnClickListener {
            sharedApp.prefs.name = etName.text.toString()
            configView() }
        btnDeleteValue.setOnClickListener {
            sharedApp.prefs.name = EMPTY_VALUE
            configView()}
    }


    fun showProfile(){
        tvName.visibility = View.VISIBLE
        tvName.text = "Hola ${sharedApp.prefs.name}"
        btnDeleteValue.visibility = View.VISIBLE
        etName.visibility = View.INVISIBLE
        btnSaveValue.visibility = View.INVISIBLE
    }

    fun showGuest(){
        tvName.visibility = View.INVISIBLE
        btnDeleteValue.visibility = View.INVISIBLE
        etName.visibility = View.VISIBLE
        btnSaveValue.visibility = View.VISIBLE
    }

    fun configView(){
        if(isSavedName()) showProfile() else showGuest()
    }

    fun isSavedName():Boolean{
        val myName = sharedApp.prefs.name
        return myName != EMPTY_VALUE
    }
}