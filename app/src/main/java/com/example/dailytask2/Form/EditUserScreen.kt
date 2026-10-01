package com.example.dailytask2.Form

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dailytask2.R
import com.google.firebase.firestore.FirebaseFirestore

class EditUserScreen : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_user_screen)

        val nameBox = findViewById<EditText>(R.id.nameBox)
        val emailBox = findViewById<EditText>(R.id.emailBox)
        val phoneBox = findViewById<EditText>(R.id.phoneBox)
        val ageBox = findViewById<EditText>(R.id.ageBox)
        val genderBox = findViewById<EditText>(R.id.genderBox)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val userId = intent.getStringExtra("id") ?: ""

        nameBox.setText(intent.getStringExtra("name"))
        emailBox.setText(intent.getStringExtra("email"))
        phoneBox.setText(intent.getStringExtra("phone"))
        ageBox.setText(intent.getStringExtra("age"))
        genderBox.setText(intent.getStringExtra("gender"))

        btnSave.setOnClickListener {

            val name = nameBox.text.toString()
            val email = emailBox.text.toString()
            val phone = phoneBox.text.toString()
            val age = ageBox.text.toString()
            val gender = genderBox.text.toString()

            val data = HashMap<String, String>()

            data["name"] = name
            data["email"] = email
            data["phone"] = phone
            data["age"] = age
            data["gender"] = gender

            db.collection("users")
                .document(userId)
                .update(data as Map<String, Any>)
                .addOnSuccessListener {

                    Toast.makeText(
                        this,
                        "User Updated",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()
                }
        }
    }
}