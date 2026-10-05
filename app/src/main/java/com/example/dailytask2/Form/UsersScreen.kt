package com.example.dailytask2.Form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailytask2.R
import com.google.firebase.firestore.FirebaseFirestore

class UsersScreen : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val db = FirebaseFirestore.getInstance()

    private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_users_screen)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        loadUsers()
    }

    private fun loadUsers() {

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->

                userList.clear()

                for (document in result) {

                    val user = User(
                        document.id,
                        document.getString("name") ?: "",
                        document.getString("email") ?: "",
                        document.getString("phone") ?: "",
                        document.getString("age") ?: "",
                        document.getString("gender") ?: ""
                    )

                    userList.add(user)
                }

                recyclerView.adapter = UserAdapter(userList)
            }
            .addOnFailureListener { error ->

                error.printStackTrace()
            }
    }
}