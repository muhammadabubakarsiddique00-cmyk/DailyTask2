package com.example.dailytask2.Form

import com.example.dailytask2.R
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.Fragment


class DetailsFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_details, container, false)

        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtEmail =view.findViewById<TextView>(R.id.txtEmail)
        val txtPhone =view.findViewById<TextView>(R.id.txtPhone)
        val txtAge= view.findViewById<TextView>(R.id.txtAge)
        val txtGender = view.findViewById<TextView>(R.id.txtGender)

        return view

    }


}