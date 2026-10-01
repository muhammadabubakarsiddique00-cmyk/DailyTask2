package com.example.dailytask2.Form

import com.example.dailytask2.R
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.example.dailytask2.Form.DetailsScreen
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class FormScreen :AppCompatActivity(){

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState:Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_form_screen)



        val nameBox = findViewById<EditText>(R.id.nameBox)
        val emailBox = findViewById<EditText>(R.id.emailBox)
        val phoneBox = findViewById<EditText>(R.id.phoneBox)
        val ageBox = findViewById<EditText>(R.id.ageBox)
        val genderBox = findViewById<EditText>(R.id.genderBox)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnOk = findViewById<Button>(R.id.btnOk)
        val btnSeeAllUsers = findViewById<Button>(R.id.btnSeeAllUsers)


        btnSubmit.setOnClickListener {

            val name = nameBox.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Name must be add", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!name.matches(Regex("[a-zA-Z]+"))) {

                Toast.makeText(this, "Name Must be Alphabet", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            val email = emailBox.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Add Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!email.contains("@") || !email.contains(".")) {

                Toast.makeText(this, ("Add proper Email"), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val phone = phoneBox.text.toString()
            if (phone.isEmpty()) {

                Toast.makeText(this, ("Add Phone Number"), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (phone.length != 11) {
                Toast.makeText(this, ("Phone Number must be of 11 numbers "), Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val age = ageBox.text.toString()

            if (age.isEmpty()) {
                Toast.makeText(this, ("Add age "), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val ageNumber = age.toIntOrNull()
            if (ageNumber == null) {

                Toast.makeText(this, ("Age must be in Number"), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (age.toInt() < 0 || age.toInt() > 100) {

                Toast.makeText(this, ("Age must be between 0-100"), Toast.LENGTH_SHORT).show()

                return@setOnClickListener

            }

            val gender = genderBox.text.toString()
            if (gender.isEmpty()) {

                Toast.makeText(this, ("Add Gender"), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (gender != "Male" && gender != "male" && gender != "Female" && gender != "female") {

                Toast.makeText(this, ("Add correct Gender"), Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            val data = HashMap<String,String>()
            data ["name"] = name
            data ["email"] = email
            data ["phone"] = phone
            data ["age"] = age
            data ["gender"]=gender

            db.collection("users").add(data)


            btnOk.setOnClickListener {

                val bundle = Bundle()

                bundle.putString("name", nameBox.text.toString())
                bundle.putString("email", emailBox.text.toString())
                bundle.putString("phone", phoneBox.text.toString())
                bundle.putString("age", ageBox.text.toString())
                bundle.putString("gender", genderBox.text.toString())

                val fragment = DetailsFragment()

                fragment.arguments = bundle

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit()
            }

            btnSeeAllUsers.setOnClickListener(){

                val intent = Intent(this,UsersScreen::class.java)
                startActivity(intent)



            }


            val intent = Intent(this , DetailsScreen::class.java)

            intent.putExtra("name",name)
            intent.putExtra("email",email)
            intent.putExtra("phone",phone)
            intent.putExtra("age",age)
            intent.putExtra("gender",gender)

            startActivity(intent)







        }

    }

}

