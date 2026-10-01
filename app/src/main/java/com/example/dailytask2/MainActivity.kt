package com.example.dailytask2

import android.content.Intent
import android.widget.Button
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dailytask2.Form.FormScreen


class MainActivity : AppCompatActivity (){

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val red = findViewById<View>(R.id.red)
        val yellow = findViewById<View>(R.id.yellow)
        val green = findViewById<View>(R.id.green)
        val btnForm = findViewById<Button>(R.id.btnForm)


        red.setOnClickListener{

            Toast.makeText(this,"Red",Toast.LENGTH_SHORT).show()
        }
        yellow.setOnClickListener{

            Toast.makeText(this,"Yellow",Toast.LENGTH_SHORT).show()
        }

        green.setOnClickListener{

            Toast.makeText(this,"Green",Toast.LENGTH_SHORT).show()
        }

        btnForm.setOnClickListener {
            val intent = Intent(this, FormScreen::class.java)
            startActivity(intent)
        }
    }
}








