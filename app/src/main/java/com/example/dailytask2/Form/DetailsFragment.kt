package com.example.dailytask2.Form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.dailytask2.R

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_details,
            container,
            false
        )

        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtEmail = view.findViewById<TextView>(R.id.txtEmail)
        val txtPhone = view.findViewById<TextView>(R.id.txtPhone)
        val txtAge = view.findViewById<TextView>(R.id.txtAge)
        val txtGender = view.findViewById<TextView>(R.id.txtGender)

        txtName.text = arguments?.getString("name")
        txtEmail.text = arguments?.getString("email")
        txtPhone.text = arguments?.getString("phone")
        txtAge.text = arguments?.getString("age")
        txtGender.text = arguments?.getString("gender")

        return view
    }
}