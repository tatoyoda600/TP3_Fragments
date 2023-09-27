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
import com.example.tp3_fragments.databinding.FragmentViewItemBinding

class ViewItem : Fragment() {
    lateinit var v: View
    lateinit var img: ImageView
    lateinit var name: TextView
    lateinit var origin: TextView
    lateinit var length: TextView
    lateinit var binding : FragmentViewItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewItemBinding.inflate(inflater, container, false)
        //v = inflater.inflate(R.layout.fragment_view_item, container, false)
        v = binding.root
        img = binding.imgAvatar
        name = binding.txtName
        origin = binding.txtOrigin
        length = binding.txtLength
        return v
    }

    override fun onStart() {
        super.onStart()

        arguments?.let {
            val obj = ViewItemArgs.fromBundle(it).recyclerObject

            Glide.with(this).load(obj.image_link).into(img)
            name.text = obj.name
            origin.text = obj.origin
            length.text = obj.length
        }
    }
}