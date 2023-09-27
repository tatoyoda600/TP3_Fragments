package com.example.tp3_fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.example.tp3_fragments.R

class ViewItem : Fragment() {
    lateinit var v: View
    lateinit var info: TextView
    lateinit var img: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_view_item, container, false)
        info = v.findViewById(R.id.txtInfo)
        img = v.findViewById(R.id.imgAvatar)
        return v
    }

    override fun onStart() {
        super.onStart()

        arguments?.let {
            val obj = ViewItemArgs.fromBundle(it).recyclerObject

            Glide.with(this).load(obj.avatar).into(img)
            info.text = obj.name
        }
    }
}