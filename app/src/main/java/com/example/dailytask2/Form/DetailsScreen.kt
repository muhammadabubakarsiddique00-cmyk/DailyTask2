package com.example.dailytask2.Form

import com.example.dailytask2.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import com.example.dailytask2.Form.FormScreen

class DetailsScreen:AppCompatActivity(){

    override fun onCreate(savedInstanceState:Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details_screen)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val txtPhone = findViewById<TextView>(R.id.txtPhone)
        val txtAge = findViewById<TextView>(R.id.txtAge)
        val txtGender = findViewById<TextView>(R.id.txtGender)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener{

            finish()
        }




        txtName.text = intent.getStringExtra("name")
        txtEmail.text = intent.getStringExtra("email")
        txtPhone.text =intent.getStringExtra("phone")
        txtAge.text =intent.getStringExtra("age")
        txtGender.text=intent.getStringExtra("gender")
    }
}
