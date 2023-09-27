package com.example.tp3_fragments.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tp3_fragments.R

class RecyclerObjectHolder(v: View) : RecyclerView.ViewHolder(v) {
    private var view: View

    init {
        this.view = v
    }

    fun setName(name: String) {
        val txt: TextView = view.findViewById(R.id.txt_name_item)
        txt.text = name
    }

    fun setAvatar(avatar: String) {
        val img: ImageView = view.findViewById(R.id.img_avatar_item)
        Glide.with(view).load(avatar).into(img)
    }

    fun getCardLayout(): CardView {
        return view.findViewById(R.id.card_package_item)
    }
}