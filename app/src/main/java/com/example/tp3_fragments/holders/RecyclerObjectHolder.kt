package com.example.tp3_fragments.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tp3_fragments.R
import com.example.tp3_fragments.databinding.RecyclerObjectItemBinding

class RecyclerObjectHolder(binding: RecyclerObjectItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private var binding: RecyclerObjectItemBinding
    private var view: View

    init {
        this.binding = binding
        this.view = binding.root
    }

    fun setName(name: String) {
        val txt: TextView = binding.txtNameItem
        txt.text = name
    }

    fun setAvatar(avatar: String) {
        val img: ImageView = binding.imgAvatarItem
        Glide.with(view).load(avatar).into(img)
    }

    fun getCardLayout(): CardView {
        return binding.cardPackageItem
    }
}