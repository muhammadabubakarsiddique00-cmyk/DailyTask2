package com.example.dailytask2.Form

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailytask2.R

class UserAdapter(
    private val userList: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtName = itemView.findViewById<TextView>(R.id.txtName)
        val txtEmail = itemView.findViewById<TextView>(R.id.txtEmail)
        val txtPhone = itemView.findViewById<TextView>(R.id.txtPhone)
        val txtAge = itemView.findViewById<TextView>(R.id.txtAge)
        val txtGender = itemView.findViewById<TextView>(R.id.txtGender)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int
    ) {

        val user = userList[position]

        holder.txtName.text = user.name
        holder.txtEmail.text = user.email
        holder.txtPhone.text = user.phone
        holder.txtAge.text = user.age
        holder.txtGender.text = user.gender

        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                EditUserScreen::class.java
            )

            intent.putExtra("id", user.id)
            intent.putExtra("name", user.name)
            intent.putExtra("email", user.email)
            intent.putExtra("phone", user.phone)
            intent.putExtra("age", user.age)
            intent.putExtra("gender", user.gender)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}